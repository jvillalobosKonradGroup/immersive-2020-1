package com.brainstation.apispring.controller;

import com.brainstation.apispring.domain.User;
import com.brainstation.apispring.security.JWTSecurity;
import com.brainstation.apispring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;
    private JWTSecurity jwtSecurity;

    public UserController(UserService userService, JWTSecurity jwtSecurity) {
        this.userService = userService;
        this.jwtSecurity = jwtSecurity;
    }

    @PostMapping("save")
    public ResponseEntity saveUser(@RequestBody User user){

        userService.saveUser(user);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody User user){

        if(userService.login(user.getUserName(),user.getPassword())){
            String jwt = jwtSecurity.generateJWT(user.getUserName());
            return new ResponseEntity(jwt,HttpStatus.OK);
        }

        return new ResponseEntity("Error",HttpStatus.BAD_REQUEST);
    }


}
