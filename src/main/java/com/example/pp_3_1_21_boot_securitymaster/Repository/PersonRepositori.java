package com.example.pp_3_1_21_boot_securitymaster.Repository;

import com.example.pp_3_1_21_boot_securitymaster.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositori extends JpaRepository<Person, Long> {
}
