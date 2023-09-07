package com.example.thuchanhmodule3_1.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate DOB;
    private String address;
    private String phone;
    private Group group;

    public Student() {
    }

    public Student(String name, String email, LocalDate DOB, String address, String phone, Group group) {
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.group = group;
    }

    public Student(int id, String name, String email, LocalDate DOB, String address, String phone, Group group) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
