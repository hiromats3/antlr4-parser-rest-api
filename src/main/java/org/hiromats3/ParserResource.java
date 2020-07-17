package org.hiromats3;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParserResource {

    @Inject
    ParserService parserService;

    @POST
    @Path("/java")
    public Response parseJava(Map<String, Object> request) {
        String input = (String)request.get("input");

        String result = parserService.parseJava(input);

        Map<String, String> response = new HashMap<>();
        response.put("result", result);
        return Response.ok(response).build();
    }
}