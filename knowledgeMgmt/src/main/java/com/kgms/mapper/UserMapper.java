package com.kgms.mapper;

import com.kgms.mapper.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wwh
 * @since 2022-11-26
 */
public interface UserMapper extends BaseMapper<User> {

//    public void createUser(User user);

    com.kgms.client.model.User getUserById(Integer id);
}
