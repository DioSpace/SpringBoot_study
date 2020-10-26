package com.my.controller;

import com.my.entity.User;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryUser")
    public List<User> queryUser(){
        List<User> users = userService.queryUser();
        return users;
    }

    @RequestMapping("/")
    public String query() {
        return "SpringBoot";
    }
}