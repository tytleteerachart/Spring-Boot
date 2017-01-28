package com.tytle.restdbcrud.service;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
        super("Invalid Input");
    }

    public UsersNotFoundException(int id) {
        super("Not Found id: " + id);
    }
}
