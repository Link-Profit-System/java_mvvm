package controller;

import com.example.generated.tables.pojos.UsersVo;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jooq.DSLContext;
import service.GreetingService;

import static com.example.generated.tables.JUsers.USERS;

@Path("/hello")
public class GreetingController {

    @Inject
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.getGreeting();
    }
}
