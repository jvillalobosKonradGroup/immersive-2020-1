package com.immersive.books.service;

import com.immersive.books.domain.User;

import java.util.List;

public interface UserService {
    public User save(User userToAdd);
    public List<User> findAllUsers();
    public User findUserById(Long userId);
    public boolean removeUser(Long userId);
    public User login(User user);
}
