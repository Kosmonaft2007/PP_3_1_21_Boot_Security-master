package com.example.pp_3_1_21_boot_securitymaster.Servis.Impl;

import com.example.pp_3_1_21_boot_securitymaster.Model.Person;
import com.example.pp_3_1_21_boot_securitymaster.Repository.PersonRepositori;
import com.example.pp_3_1_21_boot_securitymaster.Servis.PersonServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonServisImpl implements PersonServis {

    private final PersonRepositori personRepositori;

    @Autowired
    public PersonServisImpl(PersonRepositori personRepositori) {
        this.personRepositori = personRepositori;
    }


    @Override
    public Person findById(Long id) {
        Optional<Person> per =personRepositori.findById(id);
//        return per.orElse(new Person());
        return per.orElse(null);


//        return personRepositori.findById(id).orElse(null);

//        return personRepositori.findById(id).orElse(new Person());
    }

    @Override
    @Transactional (readOnly = true)
    public List<Person> findAll() {
        return personRepositori.findAll();
    }


    // PACTH UPDATE-------------------
    @Override
    @Transactional
    public void saveUser(Person person) {
         personRepositori.save(person);
    }
    @Override
    @Transactional
    public void update( Person updatePer, Long id) {
        updatePer.setId(updatePer.getId());
        personRepositori.save(updatePer);
    }

    // DELETE DELETE------------------
    @Override
    @Transactional
    public void deleteUser(Long id) {
        personRepositori.deleteById(id);

    }
}
