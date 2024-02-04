package com.example.ortiz.ProyectoIntegrador.controller.health;
import com.example.ortiz.ProyectoIntegrador.Models.User;
import com.example.ortiz.ProyectoIntegrador.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(Long.valueOf(id));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(Long.valueOf(id), user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.valueOf(id));
    }
}
