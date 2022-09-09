package dev.ifrs.factory;

import dev.ifrs.entity.User;
import dev.ifrs.view.RegisterUserView;

public class UserFactory {
    public User getUser(RegisterUserView registerUser) {
        return new User(registerUser.name, registerUser.password);
    }
}
