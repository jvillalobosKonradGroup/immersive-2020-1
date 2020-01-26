package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.User;

public interface UserDAO {

    User saveUser(User user);

    boolean login(String userName, String password);
}
