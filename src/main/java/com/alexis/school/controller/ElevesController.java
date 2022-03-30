package com.alexis.school.controller;

import com.alexis.school.dto.model.ElevesDto;
import com.alexis.school.model.User;
import com.alexis.school.service.ElevesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eleves")
public class ElevesController {

    @Resource(name = "elevesService")
    private ElevesService elevesService;

    @GetMapping("/{id}") //Key  GET + /users/id
    public User get(@PathVariable long id) {
        return elevesService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id));
    }

    @GetMapping //Key GET + /users/
    public List<User> getAll() {
        return elevesService.getAll();
    }

    @PostMapping // Key POST + /users/
    public User create(final @RequestBody ElevesDto user){
        return elevesService.create(user).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, final @RequestBody ElevesDto userDtoWithUpdate) {
        Optional<User> existingUserToUpdate = Optional.ofNullable(elevesService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id)));

        return elevesService.update(existingUserToUpdate.get(), userDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return elevesService.delete(id);
    }

}
