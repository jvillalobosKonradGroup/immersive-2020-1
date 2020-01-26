package com.brainstation.apispring.service;

import com.brainstation.apispring.domain.User;

public interface UserService {

    User saveUser(User user);

    boolean login(String userName, String password);
}
