package dev.ifrs.service;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.usecase.IUserUsecase;

public class UserService implements IUserUsecase {
    private IRepository repository;

    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    @Override
    public User registerUser(User user) {
        if (!isPasswordValid(user.getPassword())) throw new IllegalArgumentException("Senha Invalida");

        user = repository.persistUser(user);
        return user;
    }
}
