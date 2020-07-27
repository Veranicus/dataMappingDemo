package com.example.data.mapping.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("com.polacek.datasource")
//    Configuration overides values we set programatically
    public DataSource getDataSource(DataSourceProperties dataSourceProperties){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("sa3");
        dataSourceBuilder.password(securePasswordService());
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/plant");
        return dataSourceBuilder.build();
    }

    private String securePasswordService(){
        return "sa12346";
    }

}
