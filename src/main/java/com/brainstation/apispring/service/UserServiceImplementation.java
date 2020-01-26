package com.brainstation.apispring.service;

import com.brainstation.apispring.dao.UserDAO;
import com.brainstation.apispring.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    private UserDAO userDAO;

    public  UserServiceImplementation(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public User saveUser(User user) {
        if(!"".equals(user.getName())){

            userDAO.saveUser(user);

            return user;
        }

        return null;
    }

    @Override
    public boolean login(String userName, String password) {
        if(userName != "" && password != ""){


            return userDAO.login(userName,password);

        }
        return false;

    }
}
