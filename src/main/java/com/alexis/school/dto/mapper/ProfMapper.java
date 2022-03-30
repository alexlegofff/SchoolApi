package com.alexis.school.dto.mapper;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.dto.model.ProfDto;
import com.alexis.school.model.User;

import java.util.Date;

public class ProfMapper {

    public static User toUser(ProfDto profDto) {
        User prof = new User();
        prof.setName(profDto.getName());
        prof.setEmail(profDto.getEmail());
        prof.setGenderType(profDto.getGenderType());
        prof.setCreatedAt(new Date());

        return prof;
    }

}
