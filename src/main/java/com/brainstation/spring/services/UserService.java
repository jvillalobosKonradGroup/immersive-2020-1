package com.brainstation.spring.services;

import com.brainstation.spring.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class UserService {

    public abstract List listAllUsers();

    public abstract String saveUser(UserModel userModel);

    public abstract String updateUser();

    public abstract String deleteUser();

}
