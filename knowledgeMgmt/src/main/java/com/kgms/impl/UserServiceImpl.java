package com.kgms.impl;

import com.kgms.client.api.MyUserApi;
import com.kgms.client.model.User;
import com.kgms.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wwh
 * @since 2022-11-26
 */
@Service
public class UserServiceImpl implements MyUserApi {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) throws ServletException {
        User userById = userMapper.getUserById(1);
        logger.info("user info : {}", userById);
        return userById;
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
