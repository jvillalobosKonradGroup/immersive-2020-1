package com.brainstation.Practice07.controller;

import com.brainstation.Practice07.exception.AlreadyRegisteredException;
import com.brainstation.Practice07.exception.UserNotFoundException;
import com.brainstation.Practice07.model.User;
import com.brainstation.Practice07.security.TokenProvider;
import com.brainstation.Practice07.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private TokenProvider tokenProvider;

    public UserController(UserService userService, TokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token;

        user = userService.login(user);
        if(user==null){
            throw new UserNotFoundException();
        }
        token = tokenProvider.generateToken(user.getUsername());

        return new ResponseEntity<String>(token, HttpStatus.OK);

    }

    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user = userService.register(user);
        if(user == null){
            throw new AlreadyRegisteredException();
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
