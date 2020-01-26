package com.immersive.books.service.impl;

import com.immersive.books.domain.User;
import com.immersive.books.exception.ExistingUserException;
import com.immersive.books.repository.TempUserRepository;
import com.immersive.books.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private TempUserRepository tempUserRepository;

    public UserServiceImpl(TempUserRepository tempUserRepository) {
        this.tempUserRepository = tempUserRepository;
    }

    @Override
    public User save(User user) {
        if (this.tempUserRepository.emailAlreadyExists(user)) {
            throw new ExistingUserException(UserServiceImpl.class.getSimpleName());
        } else {
            return this.tempUserRepository.save(user);
        }
    }

    @Override
    public List<User> findAllUsers() {
        return this.tempUserRepository.findAllUsers();
    }

    @Override
    public User findUserById(Long userId) {
        return this.tempUserRepository.findUserById(userId);
    }

    @Override
    public boolean removeUser(Long userId) {
        return this.tempUserRepository.removeUser(userId);
    }

    public User login(User user){
        return this.tempUserRepository.findUserByEmailAndPassword(user);
    }
}
