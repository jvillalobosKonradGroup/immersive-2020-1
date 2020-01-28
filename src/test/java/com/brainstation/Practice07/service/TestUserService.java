package com.brainstation.Practice07.service;

import com.brainstation.Practice07.dao.UserDAO;
import com.brainstation.Practice07.model.User;
import com.brainstation.Practice07.dto.UserDTO;
import com.brainstation.Practice07.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserService userService = new UserServiceImpl(userDAO);

    @Test
    public void test_UserAlreadyExist(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        Mockito.when(userDAO.save(Mockito.any(UserDTO.class))).thenReturn(null);
        user = userService.register(user);

        Assert.assertNull(user);
    }

    @Test
    public void test_UserCreated(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        UserDTO newUser = new UserDTO();
        newUser.setId((long) 0);
        newUser.setUsername("username");
        newUser.setPassword("password");
        Mockito.when(userDAO.save(Mockito.any(UserDTO.class))).thenReturn(newUser);
        user = userService.register(user);

        Assert.assertNotNull(user);
    }

    @Test
    public void test_UserNotFound(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        Mockito.when(userDAO.findByUsername("username")).thenReturn(null);
        user = userService.login(user);

        Assert.assertNull(user);
    }

    @Test
    public void test_WrongUserPassword(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");


        UserDTO foundUser = new UserDTO();
        foundUser.setId((long) 0);
        foundUser.setUsername("username");
        foundUser.setPassword("anotherPassword");
        Mockito.when(userDAO.findByUsername("username")).thenReturn(foundUser);
        user = userService.login(user);

        Assert.assertNull(user);
    }

    @Test
    public void test_SuccessfulLogin(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");


        UserDTO foundUser = new UserDTO(user);
        foundUser.setId((long) 0);
        Mockito.when(userDAO.findByUsername("username")).thenReturn(foundUser);
        user = userService.login(user);

        Assert.assertNotNull(user);
    }
}
