package com.tytle.restdbcrud.repository;

import java.util.List;

import com.tytle.restdbcrud.model.Users;

public interface UsersDAO {

    public Users getById(int id);
    public List<Users> getAll(int page, int item_per_page);
    public String add(Users users);
    public String delete(int id);
}
