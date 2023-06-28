package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.User;

import java.util.List;

public interface UserServices {
    User saveUser(User a);
    User updateUser(User a);
    void deleteUser(User a);
    void deleteUserById(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
}
