package com.scube.Springboot_CRUD_app.controller;


import com.scube.Springboot_CRUD_app.ResponseModel;
import com.scube.Springboot_CRUD_app.entity.User;
import com.scube.Springboot_CRUD_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    ResponseModel responseModel = new ResponseModel();

    @Autowired
    private UserService userService;


    @PostMapping("/save_user")
    @ResponseBody

    public ResponseModel saveUser(@Validated @RequestBody User user) {

        List<User> users = userService.fetchUserList();
        System.out.println("New User -> " + user);

        for (User u : users) {
            if (user.getMobile().equals(u.getMobile())) {
                System.out.println("User already exists!");
                responseModel.setOutCode("0");
                responseModel.setOutMessage("USER ALREADY EXISTS");

                return responseModel;
            }
        }

        userService.saveUser(user);

        responseModel.setOutCode("1");
        responseModel.setOutMessage("USER SAVE SUCCESSFULLY");
        return responseModel;
    }

    @GetMapping("/fetch_user")
    @ResponseBody
    public  List<User> fetchUserList(){
        return  userService.fetchUserList();
    }

    @GetMapping("/fetch_user/{id}")
    @ResponseBody
    public  User fetchUserByid(@PathVariable("id") @RequestBody Long userId){
        return  userService.fetchUserById(userId);
    }

    @DeleteMapping("/delete_user/{id}")
    @ResponseBody
    public ResponseModel deleteUserByid(@PathVariable("id") @RequestBody Long userId) {

        User user = userService.fetchUserById(userId);
        System.out.println("Deleted User -> " + user);


            if (user.getId() != (userId)) {
                System.out.println("User Does Not exists!");
                responseModel.setOutCode("0");
                responseModel.setOutMessage("USER Does Not EXISTS");

                return responseModel;
            }


        userService.deleteUserById(userId);

        responseModel.setOutCode("1");
        responseModel.setOutMessage("USER DELETE SUCCESSFULLY");
        return responseModel;
    }

    @DeleteMapping("/update_user/{id}")
    @ResponseBody
    public ResponseModel updateUserById(@PathVariable("id") @RequestBody Long userId, User user) {

        User user1 = userService.fetchUserById(userId);
        System.out.println("Deleted User -> " + user1);


        if (user1.getId() != (userId)) {
            System.out.println("User Does Not exists!");
            responseModel.setOutCode("0");
            responseModel.setOutMessage("USER Does Not EXISTS");

            return responseModel;
        }


        userService.updateUserById(userId,user);

        responseModel.setOutCode("1");
        responseModel.setOutMessage("USER UPDATE SUCCESSFULLY");
        return responseModel;
    }


}

