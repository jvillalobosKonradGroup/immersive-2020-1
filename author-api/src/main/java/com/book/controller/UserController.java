package com.book.controller;

import com.book.model.User;
import com.book.service.AuthorService;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity getToken(@RequestBody User user) {
        if (this.userService.verifyPassword(user)) {
            String token = TokenUtils.createToken(user.getUsername());

            if(!token.equals("")) {
                return new ResponseEntity(token, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("Wrong username or password.", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/verifyToken")
    public ResponseEntity verifyToken(@RequestHeader String token) {
        if(TokenUtils.verifyToken(token)) {
            return new ResponseEntity("Valid token", HttpStatus.OK);
        } else {
            return new ResponseEntity("Invalid token", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
