package dev.ifrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import dev.ifrs.entity.User;
import dev.ifrs.factory.UserFactory;
import dev.ifrs.view.RegisterUserView;

public class UserFactoryTest {
    @Test
    void registerSuccess() {
        RegisterUserView mockedUser = new RegisterUserView();
        mockedUser.name = "name";
        mockedUser.email = "email";
        mockedUser.password = "password";
        mockedUser.passwordConfirmation = "password";

        User user = UserFactory.getUser(mockedUser);

        assertNotNull(user);
        assertEquals(mockedUser.name, user.getName());
        assertEquals(mockedUser.email, user.getEmail());
        assertEquals(mockedUser.password, user.getPassword());
        assertEquals(mockedUser.passwordConfirmation, user.getPasswordConfirmation());
    }
}
