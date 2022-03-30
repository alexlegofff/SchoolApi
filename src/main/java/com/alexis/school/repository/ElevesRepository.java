package com.alexis.school.repository;

import com.alexis.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevesRepository extends JpaRepository<User, Long> {
}
