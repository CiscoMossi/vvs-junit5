package dev.ifrs.factory;

import javax.enterprise.context.ApplicationScoped;

import dev.ifrs.entity.User;
import dev.ifrs.view.RegisterUserView;

@ApplicationScoped
public class UserFactory {
    public User getUser(RegisterUserView registerUser) {
        return new User(registerUser.name, registerUser.password);
    }
}
