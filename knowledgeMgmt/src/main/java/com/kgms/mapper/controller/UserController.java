//package com.kgms.mapper.controller;
//
//
//import com.kgms.client.model.User;
//import com.kgms.client.service.MyUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.ServletException;
//import javax.validation.constraints.NotNull;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author wwh
// * @since 2022-11-26
// */
//@RestController
//@RequestMapping("/kgms")
//public class UserController {
//
//    @Autowired
//    private MyUserService delegateService;
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public User getUserById(@NotNull Integer id) throws ServletException {
//        return delegateService.getUserById(id);
//    }
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
//    public void deleteUserById(@NotNull Integer id) throws ServletException {
//        delegateService.deleteUserById(id);
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    public void createUser(User user) throws ServletException {
//        delegateService.createUser(user);
//    }
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public void modifyUser(User user) throws ServletException {
//        delegateService.modifyUser(user);
//    }
//}
