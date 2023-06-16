package com.example.pp_3_1_21_boot_securitymaster.repository;

import com.example.pp_3_1_21_boot_securitymaster.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
