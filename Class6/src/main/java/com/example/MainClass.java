package com.example;

import com.example.dao.UserDao;
import com.example.model.User;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        UserDao dao = new UserDao();

        User newUser = new User();
        newUser.setUsername("email4");
        newUser.setEmail("email@gmail.com");
        newUser.setPassword("password");

        dao.saveUser(newUser);

        List<User> list = dao.getAllUsers();

        for(User item : list) {
            System.out.println(item.toString());
        }
    }
}
