package com.accountprovider.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mysql.cj.jdbc.MysqlXADataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.password}")
    String datasourcePassword;

    @Value("${spring.datasource.username}")
    String datasourceUsername;

    @Value("${spring.datasource.url}")
    String datasourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    String datasourceDriverClassName;

    @Bean
    DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(datasourceDriverClassName);
        dataSourceBuilder.url(datasourceUrl);
        dataSourceBuilder.username(datasourceUsername);
        dataSourceBuilder.password(datasourcePassword);
        dataSourceBuilder.type(MysqlXADataSource.class);
        return dataSourceBuilder.build();
    }
}
