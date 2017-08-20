package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mykong.test.dbcon.DBConnection;

@Path("/hello")
public class HelloWorldService
{

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg)
    {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/json/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getJson(@PathParam("param") String msg)
    {
        return DBConnection.getConnection();
    }

}