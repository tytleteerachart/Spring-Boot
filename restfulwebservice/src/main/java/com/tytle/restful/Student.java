package com.tytle.restful;

public class Student {

    private String student_id, name, university, faculty;

    public Student() {

    }

    public Student(String student_id, String name, String university, String faculty) {
        this.student_id = student_id;
        this.name = name;
        this.university = university;
        this.faculty = faculty;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
