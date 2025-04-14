package com.examine.service;


import com.examine.model.User;
import com.examine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);  // Saves a list of users
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();       // Retrieves all users
    }
}
