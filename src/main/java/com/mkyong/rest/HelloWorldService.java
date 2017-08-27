package com.mkyong.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mykong.test.dbcon.DBConnection;
import com.mykong.util.GenerateJson;

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
    
    @GET
    @Path("/maptest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String,String>> maptest(@PathParam("param") String msg)
    {
        Map<String,String> map = new HashMap<>();
        
        map.put("val1", "val2");
        map.put("val2", "val2");
        map.put("val3", "val2");
        
   Map<String,String> map2 = new HashMap<>();
        
        map2.put("val1", "val2");
        map2.put("val2", "val2");
        map2.put("val3", "val2");
        
   Map<String,String> map3 = new HashMap<>();
        
        map3.put("val1", "val2");
        map3.put("val2", "val2");
        map3.put("val3", "val2");
        
        
        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);
        list.add(map3);        
        
        
        
        return list;
    }

    
    @GET
    @Path("/generator/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<List<Map<String, String>>> getGenerator(@PathParam("param") String msg)
    {
        return GenerateJson.values(msg);
    }
}