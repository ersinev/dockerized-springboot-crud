package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User updatedUser){
        User user = getUserById(id);
        if(user != null){
            user.setName(updatedUser.getName());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
