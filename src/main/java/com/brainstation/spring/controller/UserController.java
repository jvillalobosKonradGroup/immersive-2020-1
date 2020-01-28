package com.brainstation.spring.controller;

import com.brainstation.spring.models.UserModel;
import com.brainstation.spring.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List getAllUsers(){
        return userService.listAllUsers();
    }

    @PostMapping
    public String saveUser(@RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }
}
