package com.granovskiy.dao;

import com.granovskiy.Factory;
import com.granovskiy.model.Category;
import com.granovskiy.model.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User addUser(User user) {
        String query = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement statement;

        try {
            //statement = connection.prepareStatement(query);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setNull(1, -5);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getToken());
            statement.setString(5, user.getFirstName());
            statement.setString(6, user.getLastName());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                user.setId(keys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDaoImpl(Factory.getConnection());
        Category category = categoryDao.getCategoryById(1L);
        System.out.println(category);
    }
}
