package dev.ifrs.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.ifrs.entity.User;

@ApplicationScoped
public class Repository implements IRepository {
    @Override
    public User persistUser(User user) {
        return user;
    }
}
