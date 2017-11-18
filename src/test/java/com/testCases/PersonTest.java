package com.testCases;
/*
*  Created by MOAB on 31-Jul-17.
*/

import com.controller.PersonController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Person;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest extends JerseyTest {

    private static Logger log = Logger.getLogger(PersonController.class.getName());

    private final String BASEURL = "http://pcmoab01:8081/webApi";
    private RESTClient restClient = new RESTClient();

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    @Test
    public void testGetPersonById() throws Exception {
        log.info("PersonTest -> testGetPersonById()");
        HttpResponse response = restClient.getResponse(BASEURL + "/persons/SAGPER_1");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void getAllPersons() throws Exception {
        log.info("PersonTest -> getAllPersons()");
        HttpResponse response = restClient.getResponse(BASEURL + "/persons");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void createPerson() throws Exception {
        log.info("PersonTest -> createPerson()");
        Person person = new Person("SAGPER_9", "Test", "test@gmail.com", 23);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(person);
        HttpResponse response = restClient.postResponse(BASEURL + "/persons", jsonInString);
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void updatePerson() throws Exception {
        log.info("PersonTest -> updatePerson()");
        Person person = new Person("SAGPER_5", "TestUpdate", "testUpdate@gmail.com", 26);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(person);
        HttpResponse response = restClient.postResponse(BASEURL + "/persons/SAGPER_5", jsonInString);
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void deletePerson() throws Exception {
        log.info("PersonTest -> deletePerson()");
        HttpResponse response = restClient.deleteResponse(BASEURL + "/persons/SAGPER_9");
        assertEquals(200, response.getStatusLine().getStatusCode());
    }
}
