package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.User;
import com.stage.upc.randy.pululu.repository.UserRepository;
import com.stage.upc.randy.pululu.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicesImp implements UserServices {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User a) {
        return userRepository.save(a);
    }

    @Override
    public User updateUser(User a) {
        return userRepository.save(a);
    }

    @Override
    public void deleteUser(User a) {
        userRepository.delete(a);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
