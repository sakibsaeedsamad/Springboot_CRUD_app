package com.scube.Springboot_CRUD_app.service;

import com.scube.Springboot_CRUD_app.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> fetchUserList();

    public User fetchUserById(Long userId);

    public  void deleteUserById(Long userId);

    public  User updateUserById(Long userId, User user);

}
