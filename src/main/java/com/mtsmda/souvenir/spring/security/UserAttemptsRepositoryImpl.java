package com.mtsmda.souvenir.spring.security;

import com.mtsmda.souvenir.model.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by dminzat on 6/2/2016.
 */
@Repository(value = "userAttemptsRepositoryImpl")
public class UserAttemptsRepositoryImpl extends JdbcDaoSupport implements UserAttemptsRepository {

    private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE username = ?";
    private static final String SQL_USERS_COUNT = "SELECT count(*) FROM USERS WHERE username = ?";

    private static final String SQL_USER_ATTEMPTS_GET = "SELECT * FROM USER_ATTEMPTS WHERE username = ?";
    private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO USER_ATTEMPTS (USERNAME, ATTEMPTS, LASTMODIFIED) VALUES(?,?,?)";
    private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = attempts + 1, lastmodified = ? WHERE username = ?";
    private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username = ?";

    private static final int MAX_ATTEMPTS = 3;

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void updateFailAttempts(String username) {
        UserAttempts userAttempts = getUserAttempts(username);
        if (userAttempts == null) {
            if (isUserExists(username)) {
                getJdbcTemplate().update(SQL_USER_ATTEMPTS_INSERT, new Object[]{username, 1, new Date()});
            }
        } else {
            if (isUserExists(username)) {
                getJdbcTemplate().update(SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS, new Object[]{new Date(), username});
            }

            if (userAttempts.getAttempts() + 1 >= MAX_ATTEMPTS) {
                getJdbcTemplate().update(SQL_USERS_UPDATE_LOCKED, new Object[]{false, username});
                throw new LockedException("User Account is locked!");
            }
        }
    }

    @Override
    public void resetFailAttempts(String username) {
        getJdbcTemplate().update(SQL_USER_ATTEMPTS_RESET_ATTEMPTS, new Object[]{username});
    }

    @Override
    public UserAttempts getUserAttempts(String username) {
        try {
            UserAttempts userAttempts = getJdbcTemplate().queryForObject(SQL_USER_ATTEMPTS_GET, new Object[]{username}, new RowMapper<UserAttempts>() {
                @Override
                public UserAttempts mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserAttempts userAttempt = new UserAttempts();
                    userAttempt.setId(rs.getInt("id"));
                    userAttempt.setUsername(rs.getString("username"));
                    userAttempt.setAttempts(rs.getInt("attempts"));
                    userAttempt.setLastModified(rs.getDate("lastModified"));
                    return userAttempt;
                }
            });
            return userAttempts;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isUserExists(String username) {
        boolean result = false;
        int count = getJdbcTemplate().queryForObject(SQL_USERS_COUNT, new Object[]{username}, Integer.class);
        if (count > 0) {
            result = true;
        }
        return result;
    }
}