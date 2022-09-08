package dev.ifrs.usecase;

import dev.ifrs.entity.User;

public interface IUserUsecase {
    public User registerUser(String name, String password);
}
