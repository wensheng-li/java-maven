/**
 * User Management
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.myapp.usermanagement.service;

import com.myapp.usermanagement.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    // Create
    public User addUser(String name, String email) {
        User user = new User(nextId++, name, email);
        users.add(user);
        return user;
    }

    // Read
    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    // Update
    public boolean updateUser(int id, String name, String email) {
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteUser(int id) {
        return users.removeIf(u -> u.getId() == id);
    }
}

