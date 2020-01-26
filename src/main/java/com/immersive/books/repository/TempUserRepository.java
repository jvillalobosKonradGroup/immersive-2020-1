package com.immersive.books.repository;

import com.immersive.books.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TempUserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(this.users.isEmpty() ? 0 : (long) this.users.size());
            this.users.add(user);
            return user;
        } else {
            for (User e: this.users) {
                if (e.getId().equals(user.getId())) {
                    e.setPassword(user.getPassword());
                    e.setEmail(user.getEmail());
                    return e;
                }
            }
            return null;
        }
    }

    public List<User> findAllUsers() {
        return this.users;
    }

    public User findUserById(Long userId) {
        for (User e: this.users) {
            if (e.getId().equals(userId)) return e;
        }

        return null;
    }

    public boolean removeUser (Long userId) {
        for (User e: this.users) {
            if (e.getId().equals(userId)) {
                this.users.remove(e);
                return true;
            }
        }
        return false;
    }

    public User findUserByEmailAndPassword(User user) {
        for (User e: this.users) {
            if (e.getEmail().equals(user.getEmail()) && e.getPassword().equals(user.getPassword())) return e;
        }
        return null;
    }

    public boolean emailAlreadyExists(User user) {
        for (User e: this.users) {
            if (e.getEmail().equals(user.getEmail())) return true;
        }
        return false;
    }
}
