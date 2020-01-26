package com.immersive.books.controller;

import com.immersive.books.domain.User;
import com.immersive.books.service.UserService;
import com.immersive.books.utils.JWTAuthHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private JWTAuthHelper jwtAuthHelper;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, JWTAuthHelper jwtAuthHelper) {
        this.userService = userService;
        this.jwtAuthHelper = jwtAuthHelper;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.save(user);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId) {
        return this.userService.findUserById(userId);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
//        TODO: add exceptions for logins and for already existing users.
        user = this.userService.login(user);
        String token = this.jwtAuthHelper.createToken();
        logger.info(token);
        return user;
    }
}
