package com.example.demo.service.impl;

import com.example.demo.dao.LoginDAO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired private LoginDAO loginDAO;
    @Override
    public String getUserInfo(String userId) {
        return loginDAO.getUser(userId);
    }
}
