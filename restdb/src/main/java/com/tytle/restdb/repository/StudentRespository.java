package com.tytle.restdb.repository;

import com.tytle.restdb.model.Student;
import com.tytle.restdb.mapper.StudentMapper;
import com.tytle.restdb.exception.StudentNotFoundException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class StudentRespository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public Student getById(String student_id) {
        try {
            String sql = "SELECT student_id, th_name, en_name FROM student WHERE student_id = ?;";
            return this.jdbcTemplate.queryForObject(sql, new Object[]{student_id}, new StudentMapper());
        } catch (Exception ex) {
            throw new StudentNotFoundException(student_id);
        }
    }
}
