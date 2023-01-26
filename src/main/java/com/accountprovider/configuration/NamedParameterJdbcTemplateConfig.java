package com.accountprovider.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class NamedParameterJdbcTemplateConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    public NamedParameterJdbcTemplateConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
