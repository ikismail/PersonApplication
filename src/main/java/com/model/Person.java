package com.model;

public class Person {

    private String personId;
    private String personName;
    private String personEmail;
    private int personAge;

    public Person() {
    }

    public Person(String personId, String personName, String personEmail, int personAge) {
        super();
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

}
