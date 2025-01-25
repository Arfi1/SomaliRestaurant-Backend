package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.User;
import com.example.somalirestaurantbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Integer id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
