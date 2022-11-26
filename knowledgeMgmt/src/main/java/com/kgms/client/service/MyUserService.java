package com.kgms.client.service;

import com.kgms.client.api.MyUserApi;
import com.kgms.client.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

import javax.servlet.ServletException;



@Service("com.kgms.client.service.MyUserService")
public class MyUserService {

    @Autowired
    private MyUserApi delegateApi;

    public User getUserById(@NotNull  Integer id) throws ServletException {
        return delegateApi.getUserById(id);
    }
    public void deleteUserById(@NotNull Integer id) throws ServletException {
        delegateApi.deleteUserById(id);
    }
    public void createUser(User user) throws ServletException {
        delegateApi.createUser(user);
    }
    public void modifyUser(User user) throws ServletException {
        delegateApi.modifyUser(user);
    }
}