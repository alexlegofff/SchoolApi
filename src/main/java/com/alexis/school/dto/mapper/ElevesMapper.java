package com.alexis.school.dto.mapper;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.model.User;

import java.util.Date;

public class ElevesMapper {

    public static User toUser(ElevesDto elevesDto) {
        User user = new User();
        user.setName(elevesDto.getName());
        user.setEmail(elevesDto.getEmail());
        user.setGenderType(elevesDto.getGenderType());
        user.setCreatedAt(new Date());

        return user;
    }

}
