package dev.ifrs.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dev.ifrs.entity.User;
import dev.ifrs.factory.UserFactory;
import dev.ifrs.service.UserService;
import dev.ifrs.usecase.IUserUsecase;
import dev.ifrs.view.RegisterUserView;

@Path("/user")
public class UserController {
    IUserUsecase userService = new UserService();
    UserFactory userFactory = new UserFactory();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/register")
    public void register(RegisterUserView registerUser) {
        if (registerUser != null) {
            User user = userFactory.getUser(registerUser);
    
            userService.registerUser(user);
        }
    }
}
