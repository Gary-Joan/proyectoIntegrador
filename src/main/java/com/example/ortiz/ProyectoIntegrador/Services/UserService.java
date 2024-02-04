package com.example.ortiz.ProyectoIntegrador.Services;

import com.example.ortiz.ProyectoIntegrador.Models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
