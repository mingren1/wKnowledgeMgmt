package com.kgms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kgms.client.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wwh
 * @since 2022-11-26
 */
public interface UserMapper extends BaseMapper<User> {

    public void createUser(@Param("user") User user);

    User getUserById(Long id);
}
