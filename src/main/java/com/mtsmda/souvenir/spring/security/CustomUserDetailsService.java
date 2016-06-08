package com.mtsmda.souvenir.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dminzat on 6/2/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService extends JdbcDaoImpl {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    @Value("select * from users where username = ?")
    public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
        super.setUsersByUsernameQuery(usersByUsernameQueryString);
    }

    @Value("false")
    @Override
    public void setEnableAuthorities(boolean enableAuthorities) {
        super.setEnableAuthorities(enableAuthorities);
    }

    @Value("true")
    @Override
    public void setEnableGroups(boolean enableGroups) {
        super.setEnableGroups(enableGroups);
    }

    /*@Override
    @Value("select username, role from user_roles where username = ?")
    public void setAuthoritiesByUsernameQuery(String queryString) {
        super.setAuthoritiesByUsernameQuery(queryString);
    }*/

    @Override
   /* @Value("select gm.username, ga.authority \n" +
            "from group_members gm inner join group_authorities ga on gm.group_id = ga.group_id\n" +
            "where username = ?")*/
    public void setGroupAuthoritiesByUsernameQuery(String queryString) {
        super.setGroupAuthoritiesByUsernameQuery(queryString);
    }

    @Override
    public List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>() {
            @Override
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString("username");
                String passwordC = rs.getString("passwordC");
                boolean enabled = rs.getBoolean("enabled");
                boolean accountNonExpired = rs.getBoolean("accountNonExpired");
                boolean accountNonLocked = rs.getBoolean("accountNonLocked");
                boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
                return new User(username, passwordC, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, AuthorityUtils.NO_AUTHORITIES);
            }
        });
    }

    @Override
    public UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = userFromUserQuery.getUsername();
        if (super.isUsernameBasedPrimaryKey()) {
            returnUsername = username;
        }
        return new User(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), userFromUserQuery.isAccountNonExpired(), userFromUserQuery.isCredentialsNonExpired(), userFromUserQuery.isAccountNonLocked(), combinedAuthorities);
    }
}