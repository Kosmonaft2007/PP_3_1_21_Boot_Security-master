package com.example.pp_3_1_21_boot_securitymaster.Servis;

import com.example.pp_3_1_21_boot_securitymaster.Model.Person;

import java.util.List;

public interface PersonServis {
    Person findById(Long id);

    List<Person> findAll();

     void saveUser(Person person);
    void update( Person updatePer, Long id);

    void deleteUser(Long id);
}
