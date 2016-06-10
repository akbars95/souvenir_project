package com.mtsmda.souvenir.spring.security;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dminzat on 6/9/2016.
 */
public class CustomJdbcTokenRepositoryImpl extends JdbcTokenRepositoryImpl {

    public static final String DEF_REMOVE_USER_TOKENS_SQL = "delete from persistent_logins where username_id = " +
            UserAttemptsRepositoryImpl.SQL_GET_USERNAME_ID_BY_USERNAME;
    public static final String DEF_INSERT_TOKEN_SQL = "insert into persistent_logins (username_id, series, token, last_used) values(" +
            UserAttemptsRepositoryImpl.SQL_GET_USERNAME_ID_BY_USERNAME + ",?,?,?)";
    public static final String DEF_TOKEN_BY_SERIES_SQL = "select u.username,pl.series,pl.token,pl.last_used \n" +
            "from persistent_logins pl, users u\n" +
            "where u.username_id = pl.username_id \n" +
            "and series = ?;";

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            return getJdbcTemplate().queryForObject(DEF_TOKEN_BY_SERIES_SQL,
                    new RowMapper<PersistentRememberMeToken>() {
                        public PersistentRememberMeToken mapRow(ResultSet rs, int rowNum)
                                throws SQLException {
                            return new PersistentRememberMeToken(rs.getString(1), rs
                                    .getString(2), rs.getString(3), rs.getTimestamp(4));
                        }
                    }, seriesId);
        } catch (EmptyResultDataAccessException zeroResults) {
            if (logger.isDebugEnabled()) {
                logger.debug("Querying token for series '" + seriesId
                        + "' returned no results.", zeroResults);
            }
        } catch (IncorrectResultSizeDataAccessException moreThanOne) {
            logger.error("Querying token for series '" + seriesId
                    + "' returned more than one value. Series" + " should be unique");
        } catch (DataAccessException e) {
            logger.error("Failed to load token for series " + seriesId, e);
        }

        return null;
    }

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        getJdbcTemplate().update(DEF_INSERT_TOKEN_SQL, token.getUsername(), token.getSeries(),
                token.getTokenValue(), token.getDate());
    }

    @Override
    public void removeUserTokens(String username) {
        getJdbcTemplate().update(DEF_REMOVE_USER_TOKENS_SQL, username);
    }
}