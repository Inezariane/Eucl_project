package com.eucl.service;

import org.springframework.stereotype.Service;

import com.eucl.model.*;
import com.eucl.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID :" + id));
    }
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User getUserByPhone(String phone){
        return userRepository.findByPhone(phone);
    }
    public List<User> getUsersByRole(Role role){
        return userRepository.findByRole(role);
    }
    public User updateUser(Long id, User userDetails){
        User existingUser = getUserById(id);
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setPhone(userDetails.getPhone());
        existingUser.setRole(userDetails.getRole());
        return userRepository.save(existingUser);
    }
    public void deleteUser(Long id){
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);
    }

}   




