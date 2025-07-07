package controller;

import dto.AuthRequest;
import dto.AuthResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.AuthService;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public Response login(AuthRequest request) {
        AuthResponse response = authService.authenticate(request);
        if (response == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
        return Response.ok(response).build();
    }
}