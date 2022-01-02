package com.scube.Springboot_CRUD_app.service;


import com.scube.Springboot_CRUD_app.entity.User;
import com.scube.Springboot_CRUD_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long userId)  {
        Optional<User> userOptional =
                userRepository.findById(userId);

        return  userOptional.get();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUserById(Long userId, User user) {
        Optional<User> userOptional =
                userRepository.findById(userId);

        userOptional.get();
        User existingUser =  new User();
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setMobile(user.getMobile());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);

    }
}