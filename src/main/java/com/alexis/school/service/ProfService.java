package com.alexis.school.service;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.dto.model.ProfDto;
import com.alexis.school.model.User;

import java.util.List;
import java.util.Optional;

public interface ProfService {

    Optional<User> get(long profId);

    List<User> getAll();

    Optional<User> create(ProfDto profDto);

    Optional<User> create(ElevesDto userDto);

    String delete(long userId);

    Optional<User> update(User existingUserToUpdate, ProfDto profDtoWithUpdate);

    Optional<User> update(User existingUserToUpdate, ElevesDto userDtoWithUpdate);
}
