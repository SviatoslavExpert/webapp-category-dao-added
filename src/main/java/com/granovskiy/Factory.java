package com.granovskiy;

import com.granovskiy.controller.GetAllCategoriesController;
import com.granovskiy.controller.GetCategoryByIdController;
import com.granovskiy.controller.LoginUserController;
import com.granovskiy.dao.CategoryDao;
import com.granovskiy.dao.CategoryDaoImpl;
import com.granovskiy.dao.UserDao;
import com.granovskiy.dao.UserDaoImpl;
import com.granovskiy.service.CategoryService;
import com.granovskiy.service.CategoryServiceImpl;
import com.granovskiy.service.UserService;
import com.granovskiy.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    public static UserDao getUserDaoImpl(Connection connection) {
        return new UserDaoImpl(connection);
    }


    public static GetAllCategoriesController getGetAllCategoriesController(CategoryService categoryService) {
        return new GetAllCategoriesController(categoryService);
    }

    public static CategoryService getCategoryService(CategoryDao categoryDao) {
        return new CategoryServiceImpl(categoryDao);
    }

    public static CategoryDao getCategoryDao(Connection connection) {
        return new CategoryDaoImpl(connection);
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService) {
        return new GetCategoryByIdController(categoryService);
    }
}
