package com.alexis.school.controller;

import com.alexis.school.dto.model.AddressDto;
import com.alexis.school.model.Address;
import com.alexis.school.model.User;
import com.alexis.school.service.AddressService;
import com.alexis.school.service.ElevesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Resource(name = "addressService")
    private AddressService addressService;

    @Resource(name = "elevesService")
    private ElevesService elevesService;

    @GetMapping("/{id}")
    public Address get(@PathVariable long id) {
        return addressService.get(id).orElseThrow(() -> new RuntimeException("Address not found : " + id));
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping
    public Address create(final @RequestBody AddressDto addressDto){
        User addressOwner = elevesService.get(addressDto.getAddressOwnerId()).orElseThrow(() -> new RuntimeException("User not found : " + addressDto.getAddressOwnerId()));

        return addressService.create(addressDto.getName(), addressOwner).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }
}
