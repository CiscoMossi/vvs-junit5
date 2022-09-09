package dev.ifrs.repository;

import dev.ifrs.entity.User;

public class Repository implements IRepository {
    @Override
    public User persistUser(User user) {
        return user;
    }
}
