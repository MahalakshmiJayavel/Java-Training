package com.examine.controller;

import com.examine.model.User;
import com.examine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/bulk")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable ("id")Long id, @RequestBody User updatedUser) {
        System.out.println("Print the id value: " + id);
        return userService.updateUser(id, updatedUser);
    }
}