package com.tytle.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping("/view-student")
    public Student getStudent(@RequestParam(value = "id", defaultValue = "56070067") String student_id) {
        return new Student(student_id, "Teerachart", "KMITL", "IT");
    }
}
