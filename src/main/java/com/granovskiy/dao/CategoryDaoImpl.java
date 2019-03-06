package com.granovskiy.dao;

import com.granovskiy.model.Category;
import com.granovskiy.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private final Connection connection;

    public CategoryDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Category getCategoryById(Long id) {
        String query = "SELECT C.ID AS C_ID, " +
                "C.CATEGORY_NAME AS C_NAME, " +
                "C.CATEGORY_DESCRIPTION AS C_DESC, " +
                "P.ID AS P_ID, " +
                "P.PRODUCTS_NAME AS P_NAME, " +
                "P.PRODUCTS_DESCRIPTION AS P_DESC, " +
                "P.PRICE AS P_PRICE FROM CATEGORIES C " +
                "JOIN PRODUCTS P ON C.ID = P.FK_CATEGORY_ID " +
                "WHERE C.ID = ?";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Category result = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            result = getCategoryWithProductsFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Category getCategoryWithProductsFromResultSet(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        Category result = null;

        if (rs.next()) {
            result = getCategoryFromResultSet(rs);

            while (!rs.isAfterLast()) {
                products.add(getProductFromResultSet(rs));
                rs.next();
            }

            result.setProducts(products);
        }

        return result;
    }

    private Category getCategoryFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("C_ID");
        String categoryName = rs.getString("C_NAME");
        String categoryDesc = rs.getString("C_DESC");
        return new Category(id, categoryName, categoryDesc);
    }

    private Product getProductFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("P_ID");
        String productName = rs.getString("P_NAME");
        String productDesc = rs.getString("P_DESC");
        double price = rs.getDouble("P_PRICE");
        return new Product(id, productName, productDesc, price);
    }

}