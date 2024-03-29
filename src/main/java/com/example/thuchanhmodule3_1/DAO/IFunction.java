package com.example.thuchanhmodule3_1.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IFunction<E> {
    List<E> selectAll();
    E selectOne(int id);
    void insert(E e);
    void delete(int id) throws SQLException;
    void update(E e) throws SQLException;
}
