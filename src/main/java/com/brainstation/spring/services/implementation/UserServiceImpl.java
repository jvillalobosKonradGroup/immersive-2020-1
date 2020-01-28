package com.brainstation.spring.services.implementation;

import com.brainstation.spring.DTO.User;
import com.brainstation.spring.models.UserModel;
import com.brainstation.spring.repository.UserRepository;
import com.brainstation.spring.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String saveUser(UserModel userModel) {
        User user = new User(userModel);
        user.setPassword(this.passwordEncoder.encode(userModel.getPassword()));
        user.setRoles(userModel.getRoles());
        user.setUserName(userModel.getUsername());
        userRepository.save(user);
        return "User saved";
    }

    @Override
    public String updateUser() {
        return null;
    }

    @Override
    public String deleteUser() {
        return null;
    }

}
