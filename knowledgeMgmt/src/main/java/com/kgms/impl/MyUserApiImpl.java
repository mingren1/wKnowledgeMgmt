package com.kgms.impl;

import com.kgms.client.api.MyUserApi;
import com.kgms.client.model.User;

import javax.servlet.ServletException;

public class MyUserApiImpl implements MyUserApi {
    @Override
    public User getUserById(Integer id) throws ServletException {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) throws ServletException {

    }

    @Override
    public void createUser(User user) throws ServletException {

    }

    @Override
    public void modifyUser(User user) throws ServletException {

    }
}
