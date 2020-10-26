package com.my.service.impl;

import com.my.entity.User;
import com.my.mapper.UserMapper;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        return userMapper.queryUserList();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void update(int id, String address) {
        userMapper.updateUser(id, address);
    }

    @Override
    public User query(int id) {
        return userMapper.queryUser(id);
    }
}
