package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.User;
import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
