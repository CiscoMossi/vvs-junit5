package dev.ifrs.view;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserView {
    @Size(message = "Nome inválido", min = 1)
    @NotNull(message = "Nome inválido")
    public String name;

    @Email(message = "Email inválido")
    @Size(message = "Email inválido", min = 1)
    @NotNull(message = "Email inválido")
    public String email;

    @NotNull(message = "Senha inválida")
    public String password;

    @NotNull(message = "Confirmação de senha inválida")
    public String passwordConfirmation;
}
