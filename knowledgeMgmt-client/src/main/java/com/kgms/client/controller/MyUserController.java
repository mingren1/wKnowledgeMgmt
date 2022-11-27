package com.kgms.client.controller;

import com.kgms.client.service.MyUserService;
import com.kgms.client.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kgms")
public class MyUserController {

    @Autowired
    private MyUserService delegateService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserById(@NotNull  Integer id) throws ServletException {
        return delegateService.getUserById(id);
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUserById(@NotNull Integer id) throws ServletException {
        delegateService.deleteUserById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void createUser(User user) throws ServletException {
        delegateService.createUser(user);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void modifyUser(User user) throws ServletException {
        delegateService.modifyUser(user);
    }
}