package dev.ifrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ifrs.entity.User;
import dev.ifrs.service.UserService;
import dev.ifrs.usecase.IUserUsecase;

public class UserTest {
    IUserUsecase uc;

    @BeforeEach
    void beforeEach() {
        uc = new UserService();
    }

    @Test
    void registerSuccess() {
        String name = "name";
        String password = "password";

        User user = uc.registerUser(name, password);

        assertNotNull(user);
        assertEquals(user.getName(), name);
        assertEquals(user.getPassword(), password);
    }

    @Test
    void registerFail() {
        String name = "name";
        String invalidPassword = "pass";

        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> uc.registerUser(name, invalidPassword),
           "Deveria estourar IllegalArgumentException para senha invalida"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Senha Invalida"));
    }
}
