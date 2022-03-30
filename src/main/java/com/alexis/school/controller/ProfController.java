package com.alexis.school.controller;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.dto.model.ProfDto;
import com.alexis.school.model.User;
import com.alexis.school.service.ProfService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prof")
public class ProfController {

    @Resource(name = "profService")
    private ProfService profService;

    @GetMapping("/{id}") //Key  GET + /users/id
    public User get(@PathVariable long id) {
        return profService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id));
    }

    @GetMapping //Key GET + /users/
    public List<User> getAll() {
        return profService.getAll();
    }

    @PostMapping // Key POST + /users/
    public User create(final @RequestBody ProfDto user){
        return profService.create(user).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, final @RequestBody ProfDto userDtoWithUpdate) {
        Optional<User> existingUserToUpdate = Optional.ofNullable(profService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id)));

        return profService.update(existingUserToUpdate.get(), userDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return profService.delete(id);
    }

}
