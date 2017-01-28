package com.tytle.restdb.model;

public class Student {

    private String student_id, th_name, en_name;

    public Student() {

    }

    public Student(String student_id, String th_name, String en_name) {
        this.student_id = student_id;
        this.th_name = th_name;
        this.en_name = en_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTh_name() {
        return th_name;
    }

    public void setTh_name(String th_name) {
        this.th_name = th_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    @Override
    public String toString() {
        return String.format("Student[student_id=%s, th_name=%s, en_name=%s]", student_id, th_name, en_name);
    }
}
