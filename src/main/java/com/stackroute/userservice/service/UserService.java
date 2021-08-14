package com.stackroute.userservice.service;

import java.util.List;

import com.stackroute.userservice.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
}
