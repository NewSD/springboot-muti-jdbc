package com.niu.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by ami on 2019/6/15.
 */
@Configuration
public class JDBCTemplateConfig {

    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dsOne")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dsTwo")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
