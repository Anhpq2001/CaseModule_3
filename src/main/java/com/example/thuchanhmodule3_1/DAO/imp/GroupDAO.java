package com.example.thuchanhmodule3_1.DAO.imp;

import com.example.thuchanhmodule3_1.DAO.IFunction;
import com.example.thuchanhmodule3_1.connection.MyConnection;
import com.example.thuchanhmodule3_1.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO implements IFunction<Group> {
    private static final long serialVersionUID = 1L;
    private final Connection connection = MyConnection.getInstance();
    private static final String SELECT_GROUP = "select * from `group`;";
    private static final String SELECT_GROUP_BY_ID = "select * from `group` where id = ?";
    @Override
    public List<Group> selectAll() {

        List<Group> groupList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUP)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idValue = resultSet.getInt(1);
                String nameValue = resultSet.getString(2);
                Group group = new Group(idValue, nameValue);
                groupList.add(group);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groupList;
    }

    @Override
    public Group selectOne(int id) {
        Group group = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUP_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idValue = resultSet.getInt(1);
                String nameValue = resultSet.getString(2);
                group = new Group(idValue, nameValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public void insert(Group group) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Group group) throws SQLException {

    }
}
