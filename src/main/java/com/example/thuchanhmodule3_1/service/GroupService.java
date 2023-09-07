package com.example.thuchanhmodule3_1.service;

import com.example.thuchanhmodule3_1.DAO.imp.GroupDAO;
import com.example.thuchanhmodule3_1.model.Group;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GroupService {
    GroupDAO groupDAO = new GroupDAO();
    public void displayListGroup(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Group> groupList = groupDAO.selectAll();
            request.setAttribute("groupList", groupList);
            request.getRequestDispatcher("/view/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
