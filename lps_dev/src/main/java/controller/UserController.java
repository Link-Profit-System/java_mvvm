package controller;

import com.example.generated.tables.pojos.UsersVo;
import dto.UserResponseDto;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
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
    public Response getByQueryParam(@QueryParam("id") Integer id) {
        UsersVo user = userService.getUser(id);
        UserResponseDto dto = new UserResponseDto(user.getId(), user.getName());
        return Response.ok(dto).build();
    }

    @GET
    @Path("/{id}")
    public Response getByPath(@PathParam("id") Integer id) {
        return Response.ok(userService.getUser(id)).build();
    }

    @GET
    @Path("/list")
    public Response getList() {
        return Response.ok(userService.getUsers()).build();
    }

    @POST
    public Response create(UsersVo user) {
        if (user == null || StringUtils.isEmpty(user.getName())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("User name must not be empty").build();
        }
        return Response.ok(userService.createUser(user)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, UsersVo user) {
        if (user == null || StringUtils.isEmpty(user.getName())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("User name must not be empty").build();
        }
        return Response.ok(userService.updateUser(id, user)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
