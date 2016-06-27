package com.mtsmda.souvenir.spring.security;

import com.mtsmda.souvenir.model.security.UserAttempts;
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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by dminzat on 6/2/2016.
 */
//@Repository(value = "userAttemptsRepositoryImpl")
public class UserAttemptsRepositoryImpl extends JdbcDaoSupport implements UserAttemptsRepository {

    private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE username = ?";
    private static final String SQL_USERS_COUNT = "SELECT count(*) FROM USERS WHERE username = ?";

    public static final String SQL_GET_USERNAME_ID_BY_USERNAME = "(select username_id from users where username = ?)";

    private static final String SQL_USER_ATTEMPTS_GET = "SELECT ua.id as id, u.username as username, ua.attempts as attempts, ua.lastModified as lastModified\n" +
            "FROM USER_ATTEMPTS ua, users u\n" +
            "WHERE u.username = ?";
    private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO USER_ATTEMPTS (USERNAME_ID, ATTEMPTS, LASTMODIFIED) VALUES(" + SQL_GET_USERNAME_ID_BY_USERNAME + ",?,?)";
    private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = attempts + 1, lastmodified = ? WHERE username_id = " + SQL_GET_USERNAME_ID_BY_USERNAME;
    private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username_id = " + SQL_GET_USERNAME_ID_BY_USERNAME;

    private static final int MAX_ATTEMPTS = 3;

    /*@Autowired
    @Qualifier(value = "mySqlDataSource")*/
    private DataSource dataSource;

    /*@PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }*/

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
                    userAttempt.setLastModified(LocalDateTime.ofInstant(Instant.ofEpochMilli(rs.getDate("lastModified").getTime()), ZoneId.systemDefault()));
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
