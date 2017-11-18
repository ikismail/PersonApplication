package com.controller;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.service.PersonServiceImpl;
import com.model.Person;

@Path(value = "/persons")
public class PersonController {

    static Logger log = Logger.getLogger(PersonController.class.getName());

    private PersonServiceImpl personService = new PersonServiceImpl();

    @GET
    @Produces("application/json")
    public Response getAllPersons() {
        log.info("PersonController -> getAllPersons");
        List<Person> personList = personService.personList();
        return Response.ok().entity(personList)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS, DELETE")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getPersonById(@PathParam("id") String personId) {
        log.info("PersonController -> getPersonById: " + personId);
        Person person = personService.getPersonById(personId);
        if (person == null) {
            return Response.noContent().entity(personId)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS, DELETE")
                    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
        } else {
            return Response.ok().entity(person)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
        }

    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPerson(Person person) {
        log.info("PersonController -> createPerson: " + person.getPersonName());
        personService.createPerson(person);
        return Response.ok().entity(person)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updatePerson(@PathParam("id") String id, Person person) {
        log.info("PersonController -> updatePerson: " + id + " " + person.getPersonName());
        personService.updatePerson(id, person);
        return Response.ok().entity(person)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public Response deletePerson(@PathParam("id") String personId) {
        log.info("PersonController -> deletePerson: " + personId);
        personService.deletePerson(personId);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
}
