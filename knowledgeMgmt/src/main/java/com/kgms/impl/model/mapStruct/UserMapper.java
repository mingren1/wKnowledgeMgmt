package com.kgms.impl.model.mapStruct;

import com.kgms.mapper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper instance = Mappers.getMapper(UserMapper.class);
    com.kgms.client.model.User toDto(User user);
    User toDao(com.kgms.client.model.User user);
}
