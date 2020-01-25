package com.book.service.impl;

import com.book.dto.UserDTO;
import com.book.model.User;
import com.book.repository.UserRepository;
import com.book.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean verifyPassword(User user) {
        boolean validPassword = false;

        if(verifyUser(user)) {
            UserDTO userDTO = setDTO(user);
            validPassword = this.userRepository.verifyPassword(userDTO);
        }

        return validPassword;
    }

    private boolean verifyUser(User user) {
        boolean validUser = false;

        if(user != null) {
            if(user.getUsername() != null && user.getPassword() != null) {
                validUser = true;
            }
        }

        return validUser;
    }

    private UserDTO setDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }
}
