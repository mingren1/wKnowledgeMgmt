package com.kgms.client.controller;

import com.kgms.client.service.MyUserService;
import com.kgms.client.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyUserController {

    @Autowired
    private MyUserService delegateService;

    public User getUserById(@NotNull  Integer id) throws ServletException {
    return delegateService.getUserById(id);
    }
    public void deleteUserById(@NotNull Integer id) throws ServletException {
    delegateService.deleteUserById(id);
    }
    public void createUser(User user) throws ServletException {
    delegateService.createUser(user);
    }
    public void modifyUser(User user) throws ServletException {
    delegateService.modifyUser(user);
    }
}