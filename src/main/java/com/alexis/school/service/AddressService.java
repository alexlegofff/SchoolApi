package com.alexis.school.service;

import com.alexis.school.model.Address;
import com.alexis.school.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> get(long addressId);
    List<Address> getAll();
    Optional<Address> create(String name, User addressOwner);
    Optional<Address> getByOwnerId(long addressOwnerId);
}
