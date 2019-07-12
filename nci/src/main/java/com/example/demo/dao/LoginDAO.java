package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public String getUser(String userId){
        return jdbcTemplate.queryForObject("select count(1) from t_user t where t.userId=?",String.class,userId);
    }
}
