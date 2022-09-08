package dev.ifrs.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dev.ifrs.usecase.IUserUsecase;
import dev.ifrs.view.RegisterUserView;

@Path("/user")
public class UserController {
    @Inject
    IUserUsecase userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/register")
    public void register(RegisterUserView user) {
        userService.registerUser(user.name, user.password);
    }
}
