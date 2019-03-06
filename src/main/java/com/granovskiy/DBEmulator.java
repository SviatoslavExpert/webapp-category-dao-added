package com.granovskiy;

import com.granovskiy.model.Category;
import com.granovskiy.model.Product;
import com.granovskiy.model.User;

import java.util.ArrayList;
import java.util.List;

public class DBEmulator {

    private static List<Category> categories = new ArrayList<>();

    private static List<User> users = new ArrayList<>();

    static {
        Product product = new Product(1L, "iPhone", "Apple product", 999.99);
        Product product2 = new Product(2L, "samsung", "korean product", 700.99);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        Category category = new Category(1L, "Mobile Phones", "Best ever phones");
        category.setProducts(products);
        categories.add(category);
        categories.add(new Category(2L, "Shoes", "Italian shoes"));
        categories.add(new Category(3L, "TVs", "Chines TVs"));
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
