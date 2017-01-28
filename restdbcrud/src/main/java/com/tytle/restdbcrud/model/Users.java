package com.tytle.restdbcrud.model;

public class Users {

    private int id;
    private String firstname, lastname;

    public Users() {

    }

    public Users(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "First Name: " + firstname + "\nLast Name: " + lastname;
    }
}
