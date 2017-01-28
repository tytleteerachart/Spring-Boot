package com.tytle.restdb.controller;

import com.tytle.restdb.model.Student;
import com.tytle.restdb.repository.StudentRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRespository studentRespository;

    @Autowired
    public StudentController(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @RequestMapping("/view-student")
    public Student viewStudent(@RequestParam(value = "id", defaultValue = "56070067") String student_id) {
        return studentRespository.getById(student_id);
    }

}
