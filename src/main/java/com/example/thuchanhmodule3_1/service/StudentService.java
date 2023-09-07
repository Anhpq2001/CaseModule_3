package com.example.thuchanhmodule3_1.service;

import com.example.thuchanhmodule3_1.DAO.imp.GroupDAO;
import com.example.thuchanhmodule3_1.DAO.imp.StudentDAO;
import com.example.thuchanhmodule3_1.model.Group;
import com.example.thuchanhmodule3_1.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StudentService {
    GroupDAO groupDAO = new GroupDAO();
    StudentDAO studentDAO = new StudentDAO();
    Validation validation = new Validation();
    public void displayListStudent(HttpServletRequest request, HttpServletResponse response) {
        StudentDAO studentDAO = new StudentDAO();
        GroupDAO groupDAO = new GroupDAO();
        //Validation validation = new Validation();

        try {
            List<Student> studentList = studentDAO.selectAll();
            request.setAttribute("listStudent", studentList);
            request.getRequestDispatcher("/view/display.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate DOB = LocalDate.parse(request.getParameter("DOB"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int groupId = Integer.parseInt(request.getParameter("classroom"));
        String messageErrorName = "";
        if (!validation.checkEmpty(name)) {
            messageErrorName = "Not empry!";
            request.setAttribute("messageErrorName", messageErrorName);
        }
        String messageErrorEmail = "";
        if (!validation.checkEmail(email)) {
            messageErrorEmail = "Email is existed or not format(abc@gmail.com)!";
            request.setAttribute("messageErrorEmail", messageErrorEmail);
        }
        /*String messageErrorDOB = "";
        if (!validation.checkEmpty(String.valueOf(DOB))) {
            messageErrorDOB = "Not empry!";
            request.setAttribute("messageErrorDOB", messageErrorDOB);
        }*/
        String messageErrorAddress = "";
        if (!validation.checkEmpty(address)) {
            messageErrorAddress = "Not empty!";
            request.setAttribute("messageErrorAddress", messageErrorAddress);
        }
        String messageErrorPhone = "";
        if (!validation.checkPhone(phone)) {
            messageErrorPhone = "Numberphone is existed or not format(10 digit)!";
            request.setAttribute("messageErrorPhone", messageErrorPhone);
        }
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("DOB", DOB);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);
        if (messageErrorName.equals("") && messageErrorEmail.equals("") && messageErrorAddress.equals("") && messageErrorPhone.equals("")) {
            Student student = new Student(name, email, DOB, address, phone, groupDAO.selectOne(groupId));
            studentDAO.insert(student);
            try {
                response.sendRedirect("/student?action=");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                List<Group> groupList = groupDAO.selectAll();
                request.setAttribute("groupList", groupList);
                request.getRequestDispatcher("view/create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayOneStudent(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAO.selectOne(id);
            request.setAttribute("name", student.getName());
            request.setAttribute("email", student.getEmail());
            request.setAttribute("DOB", student.getDOB());
            request.setAttribute("address", student.getAddress());
            request.setAttribute("phone", student.getPhone());
            List<Group> groupList = groupDAO.selectAll();
            request.setAttribute("groupList", groupList);
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOneStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate DOB = LocalDate.parse(request.getParameter("DOB"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int groupId = Integer.parseInt(request.getParameter("classroom"));
        Group group = groupDAO.selectOne(groupId);
        Student student = new Student(id, name, email, DOB, address, phone, group);
        studentDAO.update(student);
        try {
            response.sendRedirect("/student?action=");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteOneStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.delete(id);
        try {
            response.sendRedirect("/student?action=");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
