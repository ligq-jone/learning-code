package com.example.demo.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    HikariDataSource hikariDataSource=new HikariDataSource();
}
