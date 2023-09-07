package com.example.thuchanhmodule3_1.controller;

import com.example.thuchanhmodule3_1.service.GroupService;
import com.example.thuchanhmodule3_1.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    GroupService groupService = new GroupService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "":
                studentService.displayListStudent(request, response);
                break;
            case "create":
                groupService.displayListGroup(request, response);
                break;
            case "update":
                studentService.displayOneStudent(request, response);
                break;
            case "delete":
                studentService.deleteOneStudent(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                studentService.addNewStudent(request, response);
                break;
            case "update":
                studentService.updateOneStudent(request, response);
                break;
            case "delete":
                break;
        }
    }
}
