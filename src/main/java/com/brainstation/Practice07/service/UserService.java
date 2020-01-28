package com.brainstation.Practice07.service;

import com.brainstation.Practice07.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User register(User user);
    User login(User user);
}
