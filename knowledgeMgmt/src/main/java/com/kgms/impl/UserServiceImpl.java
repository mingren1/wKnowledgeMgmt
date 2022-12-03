package com.kgms.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.kgms.client.api.MyUserApi;
import com.kgms.client.model.User;
import com.kgms.common.IdGenerator;
import com.kgms.db.JedisServiceImpl;
import com.kgms.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private JedisServiceImpl jedisService;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public User getUserById(Long id) throws ServletException {
        // 添加redis缓存
        String userStr = jedisService.getKey(String.valueOf(id));
        if (StringUtils.isNotEmpty(userStr)) {
            return JSONObject.parseObject(userStr, User.class);
        }
        logger.info("get user from db.");
        User userDao = userMapper.getUserById(id);
        logger.info("user info : {}", userDao);

        return userDao;
    }

    @Override
    public void deleteUserById(Long id) throws ServletException {

    }

    @Override
    public void createUser(User user) throws ServletException {
        user.setId(idGenerator.snowflakeId());
        userMapper.createUser(user);
        logger.info("save db success.");
        // redis中留存
        jedisService.setKey(String.valueOf(user.getId()), JSON.toJSONString(user));
        logger.info("createUser success end.");
    }

    @Override
    public void modifyUser(User user) throws ServletException {

    }
}
