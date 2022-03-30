package com.alexis.school.service;

import com.alexis.school.dto.mapper.ElevesMapper;
import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.model.User;
import com.alexis.school.repository.ElevesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("elevesService")
public class ElevesServiceImpl implements ElevesService {
    @Autowired
    ElevesRepository elevesRepository;

    @Override
    public Optional<User> get(long userId) {
        return elevesRepository.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return elevesRepository.findAll();
    }

    @Override
    public Optional<User> create(ElevesDto userDto) {
        return Optional.of( elevesRepository.save(ElevesMapper.toUser(userDto)));
    }

    @Override
    public String delete(long userId) {
        elevesRepository.deleteById(userId);
        return "user deleted with success";
    }

    @Override
    public Optional<User> update(User existingUserToUpdate, ElevesDto userDtoWithUpdate) {
        // -- Update existing user informations
        existingUserToUpdate.setName(userDtoWithUpdate.getName());
        existingUserToUpdate.setEmail(userDtoWithUpdate.getEmail());
        existingUserToUpdate.setGenderType(userDtoWithUpdate.getGenderType());

        // -- Update existing user in DB with new informations
        Optional<User> updatedUser = Optional.of(elevesRepository.save(existingUserToUpdate));

        return updatedUser;
    }


}
