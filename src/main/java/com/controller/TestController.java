package com.controller;

import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestController {

    static Logger log = Logger.getLogger(TestController.class.getName());

    @GET
    @Produces("application/json")
    public String sayHello() {
        return "Hello World";
    }


}
