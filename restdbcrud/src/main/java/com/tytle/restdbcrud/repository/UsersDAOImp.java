package com.tytle.restdbcrud.repository;

import java.util.List;

import com.tytle.restdbcrud.model.Users;
import com.tytle.restdbcrud.mapper.UsersMapper;
import com.tytle.restdbcrud.service.UsersNotFoundException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class UsersDAOImp implements UsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public Users getById(int id) {
        final String SELECT_SQL = "SELECT id, firstname, lastname FROM users WHERE id = ?;";

        try {
            return this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{id}, new UsersMapper());
        } catch (NumberFormatException ex) {
            throw new UsersNotFoundException();
        } catch (Exception ex) {
            throw new UsersNotFoundException(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "item_per_page", defaultValue = "10") int item_per_page) {
        List<Users> usersList;
        final String SELECT_SQL = "SELECT id, firstname, lastname FROM users LIMIT ? OFFSET ?;";

        try {
            if (item_per_page > 0) {
                int offset = item_per_page * (page - 1);
                usersList = this.jdbcTemplate.query(SELECT_SQL, new Object[]{item_per_page, offset}, new UsersMapper());
            } else {
                throw new UsersNotFoundException();
            }
        } catch (Exception ex) {
            throw new UsersNotFoundException();
        }

        return usersList;
    }

    @Override
    @Transactional
    public String add(Users users) {
        final String INSERT_SQL = "INSERT INTO users (firstname, lastname) VALUES (?, ?);";

        try {
            if (users.getFirstname().equals("1") || users.getLastname().equals("1")) {
                return "Empty Firstname or Lastname";
            } else {
                if (this.jdbcTemplate.update(INSERT_SQL, users.getFirstname(), users.getLastname()) > 0) {
                    return "Add user successfully: " + users;
                } else {
                    return "Something went wrong";
                }
            }
        } catch (Exception ex) {
            throw new UsersNotFoundException();
        }
    }

    @Override
    @Transactional
    public String delete(int id) {
        final String DELETE_SQL = "DELETE FROM users WHERE id=?;";

        try {
            if (id == 0) {
                throw new Exception();
            } else {
                if (this.jdbcTemplate.update(DELETE_SQL, id) > 0) {
                    return "Delete Sucessfully ID: " + id;
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception ex) {
            return "Something went wrong";
        }
    }
}
