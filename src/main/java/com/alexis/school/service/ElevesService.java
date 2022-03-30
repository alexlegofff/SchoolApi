package com.alexis.school.service;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.model.User;

import java.util.List;
import java.util.Optional;

public interface ElevesService {

    Optional<User> get(long userId);

    List<User> getAll();

    Optional<User> create(ElevesDto elevesDto);

    String delete(long userId);

    Optional<User> update(User existingUserToUpdate, ElevesDto elevesDtoWithUpdate);
}
