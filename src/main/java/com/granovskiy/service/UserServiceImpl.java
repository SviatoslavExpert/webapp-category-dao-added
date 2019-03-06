package com.granovskiy.service;

import com.granovskiy.DBEmulator;
import com.granovskiy.dao.UserDao;
import com.granovskiy.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> authorize(User user) {
        Optional<User> u = DBEmulator.getUsers().stream()
                .filter(r -> r.getUsername().equals(user.getUsername()))
                .findFirst();

        /*if (u.isPresent()) {
            if(u.get().getPassword().equals(sha256(user.getPassword()))) {
                return u;
            }
        }*/

        return u.map(User::getPassword)
                .filter(p -> p.equals(sha256(user.getPassword())))
                .flatMap(p -> u);  //temporary
    }

    @Override
    public Optional<User> addUser(User user) {
        String hashedPassword = sha256(user.getPassword());
        user.setPassword(hashedPassword);
        user.setToken(generateToken());
        return Optional.ofNullable(userDao.addUser(user));
    }

    @Override
    public Optional<User> findByToken(String token) {
        return DBEmulator.getUsers().stream()
                .filter(u -> u.getToken().equals(token))
                .findFirst();
    }

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
