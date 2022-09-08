package dev.ifrs.service;

import javax.inject.Singleton;

import dev.ifrs.entity.User;
import dev.ifrs.usecase.IUserUsecase;

@Singleton
public class UserService implements IUserUsecase {
    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public User registerUser(String name, String password) {
        if (!isPasswordValid(password)) throw new IllegalArgumentException("Senha Invalida");

        return new User(name, password);
    }
}
