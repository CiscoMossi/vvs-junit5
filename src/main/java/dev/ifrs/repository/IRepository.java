package dev.ifrs.repository;

import dev.ifrs.entity.User;

public interface IRepository {
    public User persistUser(User user);
}
