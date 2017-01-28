package com.tytle.restdbcrud.controller;

import java.util.List;

import com.tytle.restdbcrud.model.Users;
import com.tytle.restdbcrud.repository.UsersDAOImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private final UsersDAOImp usersDAOImp;

    @Autowired
    public UsersController(UsersDAOImp usersDAOImp) {
        this.usersDAOImp = usersDAOImp;
    }

    @RequestMapping("/user")
    public Users getUser(@RequestParam(value = "id", defaultValue = "1") int id) {
        return usersDAOImp.getById(id);
    }

    @RequestMapping("/users")
    public List<Users> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "item_per_page", defaultValue = "10") int item_per_page) {
        return usersDAOImp.getAll(page, item_per_page);
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam(value = "firstname", defaultValue = "1") String firstname,
                          @RequestParam(value = "lastname", defaultValue = "1") String lastname) {
        return usersDAOImp.add(new Users(firstname, lastname));
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", defaultValue = "0") int id) {
        return usersDAOImp.delete(id);
    }
}
