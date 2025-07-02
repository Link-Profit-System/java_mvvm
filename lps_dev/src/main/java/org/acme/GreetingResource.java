package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

@Path("/hello")
public class GreetingResource {

    @Inject
    DSLContext dsl;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Result<org.jooq.Record> result = dsl.fetch("SELECT id, name FROM users");
        StringBuilder sb = new StringBuilder();
        for (Record r : result) {
            sb.append(r.get("id")).append(": ").append(r.get("name")).append("\n");
        }
        return sb.toString();
    }
}
