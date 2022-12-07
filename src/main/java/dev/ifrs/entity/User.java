package dev.ifrs.entity;

public class User {
    private String name;
    private String email;
    private String password;
    private String passwordConfirmation;

    public User(String name, String email, String password, String passwordConfirmation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }
}
