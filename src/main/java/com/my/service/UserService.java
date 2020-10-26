package com.my.service;

import com.my.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();

    void addUser(User user);

    void deleteUser(int id);

    void update(int id, String address);

    User query(int id);
}
