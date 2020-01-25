package com.book.service;

import com.book.dto.UserDTO;
import com.book.model.User;
import com.book.repository.UserRepository;
import com.book.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserServiceTests {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void test_VerifyPasswordUserNotNullAndPasswordCorrect() {
        User user = new User();
        user.setPassword("password");
        user.setUsername("aduarte95");
        Mockito.when(this.userRepository.verifyPassword(Mockito.any(UserDTO.class)))
                .thenReturn(true);
        boolean validPassword = this.userService.verifyPassword(user);

        Assert.isTrue(validPassword, "invalid" );
    }

    @Test
    public void test_VerifyPasswordUserNull() {
        User user = null;
        boolean validPassword = this.userService.verifyPassword(user);

        Assert.isTrue(!validPassword, "invalid" );
    }
}
