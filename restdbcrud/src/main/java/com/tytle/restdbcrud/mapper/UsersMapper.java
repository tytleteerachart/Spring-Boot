package com.tytle.restdbcrud.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tytle.restdbcrud.model.Users;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getInt("id"));
        users.setFirstname(resultSet.getString("firstname"));
        users.setLastname(resultSet.getString("lastname"));
        return users;
    }
}
