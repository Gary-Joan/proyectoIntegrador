package com.example.ortiz.ProyectoIntegrador.Services;

import com.example.ortiz.ProyectoIntegrador.Models.User;
import com.example.ortiz.ProyectoIntegrador.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }



    @Override
    public User getUserById(Long id) {
        return userRepository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(String.valueOf(id))) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }
}
