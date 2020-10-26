package com.my.controller;

import com.my.entity.User;
import com.my.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("queryUser")
    public List<User> queryUser() {
        List<User> users = userService.queryUser();
        return users;
    }

    //username, birthday, sex, address
    @PostMapping("addUser")
    public String add(@RequestParam("username") String username,
                      @RequestParam("birthday") Date birthday,
                      @RequestParam("sex") int sex,
                      @RequestParam("address") String address) {
        if (username.equals("")) {
            return "用户名不能为空";
        } else {
            User user = new User();
            user.setUsername(username);
            user.setBirthday(birthday);
            user.setSex(sex);
            user.setAddress(address);
            userService.addUser(user);
            return "添加成功!";
        }
    }

    @PostMapping("deleteUser")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "删除成功!";
    }

    @PostMapping("updateUser")
    public String update(@RequestParam("id") int id, @RequestParam("address") String address) {
        userService.update(id, address);
        return "修改成功!";
    }

    @PostMapping("query")
    public User query(@RequestParam("id") int id) {
        return userService.query(id);
    }
}