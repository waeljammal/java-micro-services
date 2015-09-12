package com.op.service.security.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {
    @Bean
    UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        RowMapper<User> userDetailsRowMapper = (rs, i) -> new User(
                rs.getString("ACCOUNT_NAME"),
                rs.getString("PASSWORD"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));

        return username -> jdbcTemplate.queryForObject(
                "select * from ACCOUNT where ACCOUNT_NAME = ?",
                userDetailsRowMapper, username);
    }
}