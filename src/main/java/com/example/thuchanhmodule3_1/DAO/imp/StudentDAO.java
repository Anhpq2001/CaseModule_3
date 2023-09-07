package com.example.thuchanhmodule3_1.DAO.imp;

import com.example.thuchanhmodule3_1.DAO.IFunction;
import com.example.thuchanhmodule3_1.connection.MyConnection;
import com.example.thuchanhmodule3_1.model.Group;
import com.example.thuchanhmodule3_1.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudentDAO implements IFunction<Student> {
    private static final long serialVersionUID = 1L;
    private final Connection connection = MyConnection.getInstance();
    GroupDAO groupDAO = new GroupDAO();
    private static final String SELECT_STUDENT = "select * from student;";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id =?";
    private static final String INSERT_STUDENT = "insert into student(name, email, address, DOB, phone, g_id) value(?,?,?,?,?,?)";
    private static final String UPDATE_STUDENT = "update student set name = ?, email = ?, DOB = ?, address = ?, phone = ?, g_id = ? where id = ?;";
    private static final String DELETE_STUDENT = "delete from student where id = ?;";
    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                LocalDate DOB = LocalDate.parse(resultSet.getString(4));
                String address = resultSet.getString(5);
                String phone = resultSet.getString(6);
                int g_id = resultSet.getInt(7);
                Group group = groupDAO.selectOne(g_id);
                Student student = new Student(id, name, email, DOB, address, phone, group);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student selectOne(int id) {
        Student student = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idValue = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                LocalDate DOB = LocalDate.parse(resultSet.getString(4));
                String address = resultSet.getString(5);
                String phone = resultSet.getString(6);
                int g_id = resultSet.getInt(7);
                Group group = groupDAO.selectOne(g_id);
                student = new Student(idValue, name, email, DOB, address, phone, group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void insert(Student student) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)){
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, String.valueOf(student.getDOB()));
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getGroup().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student){
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setObject(3, student.getDOB());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getGroup().getId());
            preparedStatement.setInt(7, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
