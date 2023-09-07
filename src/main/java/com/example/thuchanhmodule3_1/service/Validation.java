package com.example.thuchanhmodule3_1.service;

import com.example.thuchanhmodule3_1.DAO.imp.StudentDAO;
import com.example.thuchanhmodule3_1.model.Student;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    StudentDAO studentDAO = new StudentDAO();
    final String PHONE_PATTERN = "^[0][0-9]{9}$";
    final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public boolean checkEmpty(String input) {
        boolean check = false;
        if (!input.equals("")) {
            check = true;
        }
        return check;
    }

    public boolean checkPhone(String phone) {
        boolean check = false;
        if (Pattern.matches(PHONE_PATTERN, phone) && checkPhoneExist(phone)) {
            check = true;
        }
        return check;
    }


    public boolean checkEmail(String email) {
        boolean check = false;
        if (Pattern.matches(EMAIL_PATTERN, email) && checkEmailExist(email)) {
            check = true;
        }
        return check;
    }


    public boolean checkPhoneExist(String input) {
        boolean check = true;
        List<Student> studentList = studentDAO.selectAll();
        for (Student student : studentList) {
            if (student.getPhone().equals(input)) {
                check = false;
            }
        }
        return check;
    }

    public boolean checkEmailExist(String input) {
        boolean check = true;
        List<Student> studentList = studentDAO.selectAll();
        for (Student student : studentList) {
            if (student.getEmail().equals(input)) {
                check = false;
            }
        }
        return check;
    }
}
