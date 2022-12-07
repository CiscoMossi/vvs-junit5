package dev.ifrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import javax.ws.rs.BadRequestException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserTest {
    @Mock
    IRepository repo;

    @InjectMocks
    UserService uc;

    @Test
    void validatePasswordCorrectly() {
        String validPassword = "12345678";
        String invalidPassword = "123";
        String nullPassword = null;

        assertTrue(uc.isPasswordValid(validPassword));
        assertFalse(uc.isPasswordValid(invalidPassword));
        assertFalse(uc.isPasswordValid(nullPassword));
    }

    @Test
    void registerSuccess() {
        String name = "name";
        String email = "email";
        String password = "password";
        String passwordConfirmation = "password";
        User mockedUser = new User(name, email, password, passwordConfirmation);

        when(repo.persistUser(mockedUser)).thenReturn(mockedUser);
        User user = uc.registerUser(mockedUser);

        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(passwordConfirmation, user.getPasswordConfirmation());
    }

    @Test
    void registerFail() {
        String name = "name";
        String email = "email";
        String password = "pass";
        String passwordConfirmation = "pass";
        User mockedUser = new User(name, email, password, passwordConfirmation);

        BadRequestException thrown = assertThrows(
            BadRequestException.class,
           () -> uc.registerUser(mockedUser),
           "Deveria estourar BadRequestException para Senha inválida"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Senha inválida"));
    }

    @Test
    void registerFailNullPassword() {
        String name = "name";
        String email = "email";
        String password = null;
        String passwordConfirmation = null;
        User mockedUser = new User(name, email, password, passwordConfirmation);

        BadRequestException thrown = assertThrows(
            BadRequestException.class,
           () -> uc.registerUser(mockedUser),
           "Deveria estourar BadRequestException para Senha inválida"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Senha inválida"));
    }

    @Test
    void registerFailWrongPasswordConfirmation() {
        String name = "name";
        String email = "email";
        String password = "password";
        String passwordConfirmation = "password123";
        User mockedUser = new User(name, email, password, passwordConfirmation);

        BadRequestException thrown = assertThrows(
            BadRequestException.class,
           () -> uc.registerUser(mockedUser),
           "Deveria estourar BadRequestException para Confirmação de senha errada"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("As senhas não conferem"));
    }
}
