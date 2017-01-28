package com.tytle.restdb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tytle.restdb.model.Student;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setStudent_id(resultSet.getString("student_id"));
        student.setTh_name(resultSet.getString("th_name"));
        student.setEn_name(resultSet.getString("en_name"));
        return student;
    }
}
