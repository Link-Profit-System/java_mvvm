package controller;

import com.example.generated.tables.pojos.UsersVo;
import dto.UserResponse;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jooq.tools.StringUtils;
import service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @RolesAllowed("user-read")
    public Response getByQueryParam(@QueryParam("id") Integer id) {
        UsersVo user = userService.getUser(id);
        UserResponse dto = new UserResponse(user.getId(), user.getEmail());
        return Response.ok(dto).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("user-read")
    public Response getByPath(@PathParam("id") Integer id) {
        return Response.ok(userService.getUser(id)).build();
    }

    @GET
    @Path("/list")
    @RolesAllowed("user-read")
    public Response getList() {
        return Response.ok(userService.getUsers()).build();
    }

    @POST
    @RolesAllowed("user-write")
    public Response create(UsersVo user) {
        if (user == null || StringUtils.isEmpty(user.getEmail())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("User name must not be empty").build();
        }
        return Response.ok(userService.createUser(user)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("user-write")
    public Response update(@PathParam("id") Integer id, UsersVo user) {
        if (user == null || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getName())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("User password or name must not be empty").build();
        }
        return Response.ok(userService.updateUser(id, user)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("user-write")
    public Response delete(@PathParam("id") Integer id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
