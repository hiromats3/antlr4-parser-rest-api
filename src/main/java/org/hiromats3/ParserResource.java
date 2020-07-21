package org.hiromats3;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hiromats3.java.JavaParserService;

@Path("/parser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParserResource {

    @Inject
    JavaParserService javaParser;

    @POST
    @Path("/java")
    public Response parseJava(Map<String, Object> request) {
        String input = (String)request.get("input");
        return Response.ok(javaParser.parse(input)).build();
    }
}