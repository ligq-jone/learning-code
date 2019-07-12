package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
@Autowired private LoginService loginService;
    @RequestMapping("/say/{userId}")
    public  String sayHello(@PathVariable String userId){
        System.out.println("----------");
        return loginService.getUserInfo(userId);
//        return "爱你11 spring-boot";
    }
}
