package dev.ifrs.controller;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.ifrs.entity.User;
import dev.ifrs.entity.Error;
import dev.ifrs.factory.UserFactory;
import dev.ifrs.usecase.IUserUsecase;
import dev.ifrs.view.RegisterUserView;

@Path("/user")
public class UserController {
    @Inject
    IUserUsecase userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(@Valid RegisterUserView registerUser) {
        try {
            if (registerUser == null) throw new BadRequestException("Usuário inválido");
            
            User user = UserFactory.getUser(registerUser);
    
            userService.registerUser(user);
            URI userCreationPath = URI.create(user.getName());

            return Response.created(userCreationPath).build();
        } catch (ClientErrorException e) {
            return new Error().toResponse(e);
        }
    }
}
