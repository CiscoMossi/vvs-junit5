package dev.ifrs.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.usecase.IUserUsecase;

@ApplicationScoped
public class UserService implements IUserUsecase {
    @Inject
    private IRepository repository;

    public boolean isPasswordValid(String password) {
        if (password == null) return false;

        return password.length() >= 8;
    }

    @Override
    public User registerUser(User user) {
        if (!isPasswordValid(user.getPassword())) throw new BadRequestException("Senha Invalida");

        user = repository.persistUser(user);
        return user;
    }
}
