package dev.ifrs.factory;

import dev.ifrs.entity.User;
import dev.ifrs.view.RegisterUserView;

public class UserFactory {
    private UserFactory() {
        throw new IllegalStateException("Classe utilitária, utilize os métodos estáticos");
    }

    public static User getUser(RegisterUserView registerUser) {
        return new User(
            registerUser.name,
            registerUser.email,
            registerUser.password,
            registerUser.passwordConfirmation
        );
    }
}
