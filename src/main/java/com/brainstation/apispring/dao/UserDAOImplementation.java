package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.User;
import com.brainstation.apispring.security.JWTSecurity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDAOImplementation implements UserDAO{

    ArrayList<User> users = new ArrayList<>();
    private JWTSecurity jwtSecurity;

    @Override
    public User saveUser(User user) {
       users.add(user);
       return user;
    }

    @Override
    public boolean login(String userName, String password) {

        for(User userLogin : users){
             if(userLogin.getUserName().equals(userName) && userLogin.getPassword().equals(password)){

                 return true;
             }
        }

        return false;
    }
}
