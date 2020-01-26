package com.immersive.books.service;

import com.immersive.books.domain.User;
import com.immersive.books.exception.ExistingUserException;
import com.immersive.books.repository.TempUserRepository;
import com.immersive.books.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    TempUserRepository tempUserRepository;

    @InjectMocks
    UserService service = new UserServiceImpl(this.tempUserRepository);

    @Test
    public void test_saveNewUser() {
        User newUser = new User("email", "password");
        User registeredUser = new User((long) 0, "email", "password");

        when(tempUserRepository.emailAlreadyExists(newUser)).thenReturn(false);
        when(tempUserRepository.save(any(User.class))).thenReturn(registeredUser);

        assertNotEquals(newUser.getId(), service.save(newUser).getId());
    }

    @Test
    public void test_emailAlreadyExist() {
        when(tempUserRepository.emailAlreadyExists(any(User.class))).thenReturn(true);
        assertThrows(ExistingUserException.class, () -> {
            service.save(new User("email","password"));
        });
    }

    @Test
    public void test_callFindAllUsers() {
        ArrayList users = new ArrayList<>();
        when(tempUserRepository.findAllUsers()).thenReturn(users);
        service.findAllUsers();
        assertEquals(users, service.findAllUsers());
    }

    @Test
    public void test_findUserById() {
        Long givenId = 0L;
        User foundUser = new User(givenId, "email", "password");
        when(tempUserRepository.findUserById(givenId)).thenReturn(foundUser);
        assertEquals(givenId, service.findUserById(givenId).getId());
    }

    @Test
    public void test_callRemoveUser() {
        when(tempUserRepository.removeUser(any(long.class))).thenReturn(false);
        service.removeUser(0L);
        verify(tempUserRepository, times(1)).removeUser(0L);
    }

    @Test
    public void test_login() {
        User user = new User("email", "password");
        User loggedUser = new User(0L, "email", "password");
        when(tempUserRepository.findUserByEmailAndPassword(user)).thenReturn(loggedUser);
        assertNotEquals(user.getId(), service.login(user));
    }
}
