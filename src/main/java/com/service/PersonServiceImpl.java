package com.service;

import com.model.Person;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonServiceImpl {

    static Logger log = Logger.getLogger(PersonServiceImpl.class.getName());

    static HashMap<Integer, Person> personMap = getPersonMap();

    public PersonServiceImpl() {
        if (personMap == null) {
            personMap = new HashMap<Integer, Person>();
            personMap.put(1, new Person("SAGPER_1", "John Doe", "johndoe@gmail.com", 23));
            personMap.put(2, new Person("SAGPER_2", "Jack Smith", "jacksmith@gmail.com", 21));
            personMap.put(3, new Person("SAGPER_3", "Marry Jones", "marryjone@gmail.com", 25));
            personMap.put(4, new Person("SAGPER_4", "Johnson", "johnson@gmail.com", 24));
            personMap.put(5, new Person("SAGPER_5", "Jane Doe", "janedoe@gmail.com", 22));
            personMap.put(6, new Person("SAGPER_6", "Richard Roe", "richardroe@gmail.com", 28));
            personMap.put(7, new Person("SAGPER_7", "Jane Roe", "janeroe@gmail.com", 27));
            personMap.put(8, new Person("SAGPER_8", "Jane Smith", "janesmith@gmail.com", 26));
        }
    }

    public List<Person> personList() {
        log.info("PersonServiceImpl -> personList");
        List<Person> persons = new ArrayList<Person>(personMap.values());
        return persons;
    }

    public Person getPersonById(String id) {
        log.info("PersonServiceImpl -> getPersonById");
        String[] parts = id.split("_");
        String part1 = parts[0];
        String part2 = parts[1];
        Person person = personMap.get(Integer.parseInt(part2));
        return person;
    }

    public Person createPerson(Person person) {
        log.info("PersonServiceImpl -> createPerson");
        int id = personMap.size() + 1;
        person.setPersonId("SAGPER_" + id);
        personMap.put(id, person);
        return person;
    }

    public Person updatePerson(String id, Person person) {
        log.info("PersonServiceImpl -> updatePerson");
        if (id == null)
            return null;
        String[] parts = id.split("_");
        String part1 = parts[0];
        String part2 = parts[1];
        personMap.put(Integer.parseInt(part2), person);
        return person;
    }

    public void deletePerson(String id) {
        log.info("PersonServiceImpl -> deletePerson");
        String[] parts = id.split("_");
        String part1 = parts[0];
        String part2 = parts[1];
        personMap.remove(Integer.parseInt(part2));
    }

    public static HashMap<Integer, Person> getPersonMap() {
        return personMap;
    }

}
