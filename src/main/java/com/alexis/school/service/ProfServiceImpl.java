package com.alexis.school.service;

import com.alexis.school.dto.mapper.ProfMapper;
import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.dto.model.ProfDto;
import com.alexis.school.model.User;
import com.alexis.school.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("profService")
public class ProfServiceImpl implements ProfService {
    @Autowired
    ProfRepository profRepository;

    @Override
    public Optional<User> get(long userId) {
        return profRepository.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return profRepository.findAll();
    }

    @Override
    public Optional<User> create(ProfDto profDto) {
        return Optional.of( profRepository.save(ProfMapper.toUser(profDto)));
    }

    @Override
    public Optional<User> create(ElevesDto userDto) {
        return Optional.empty();
    }

    @Override
    public String delete(long userId) {
        profRepository.deleteById(userId);
        return "user deleted with success";
    }

    @Override
    public Optional<User> update(User existingUserToUpdate, ProfDto userDtoWithUpdate) {
        // -- Update existing user informations
        existingUserToUpdate.setName(userDtoWithUpdate.getName());
        existingUserToUpdate.setEmail(userDtoWithUpdate.getEmail());
        existingUserToUpdate.setGenderType(userDtoWithUpdate.getGenderType());

        // -- Update existing user in DB with new informations
        Optional<User> updatedUser = Optional.of(profRepository.save(existingUserToUpdate));

        return updatedUser;
    }

    @Override
    public Optional<User> update(User existingUserToUpdate, ElevesDto userDtoWithUpdate) {
        return Optional.empty();
    }


}
