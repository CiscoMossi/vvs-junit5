package dev.ifrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class UserTest {
    @Mock
    IRepository repo;

    @InjectMocks
    UserService uc;

    @Test
    void registerSuccess() {
        String name = "name";
        String password = "password";
        User mockedUser = new User(name, password);

        when(repo.persistUser(mockedUser)).thenReturn(mockedUser);
        User user = uc.registerUser(mockedUser);

        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    void registerFail() {
        String name = "name";
        String invalidPassword = "pass";
        User mockedUser = new User(name, invalidPassword);

        BadRequestException thrown = assertThrows(
            BadRequestException.class,
           () -> uc.registerUser(mockedUser),
           "Deveria estourar BadRequestException para senha invalida"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Senha Invalida"));
    }
}
