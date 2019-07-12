package com.nci.jifen.jifen.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JifenController {
    @RequestMapping(value = "/jifen/{id}")
    public Integer getJifenInfo(@PathVariable String id){
        return Integer.valueOf(id);
    }
}
