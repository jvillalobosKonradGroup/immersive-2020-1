package com.brainstation.Practice07.service.impl;

import com.brainstation.Practice07.dao.UserDAO;
import com.brainstation.Practice07.model.User;
import com.brainstation.Practice07.service.UserService;
import com.brainstation.Practice07.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User register(User user) {
        UserDTO userDTO;

        userDTO = userDAO.save(new UserDTO(user));
        if (userDTO != null) {
            return new User(userDTO);
        }

        return null;
    }

    @Override
    public User login(User user) {
        UserDTO userDTO = userDAO.findByUsername(user.getUsername());

        if (userDTO != null) {
            if (userDTO.getPassword().equals(user.getPassword())) {
                return new User(userDTO);
            } else {
                return null;
            }
        }
        return null;
    }
}
