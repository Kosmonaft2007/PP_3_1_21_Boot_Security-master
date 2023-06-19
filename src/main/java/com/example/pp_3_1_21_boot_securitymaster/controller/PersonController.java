package com.example.pp_3_1_21_boot_securitymaster.controller;

import com.example.pp_3_1_21_boot_securitymaster.model.Person;
import com.example.pp_3_1_21_boot_securitymaster.servis.PersonServis;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller // почему НЕ @RESTController?????????

public class PersonController {
    public final PersonServis personServis;

    public PersonController(PersonServis personServis) {
        this.personServis = personServis;
    }


    //показать всех _______________________________________________________________________________
    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("peoples", personServis.findAll());
        return "allUsers";
    }

    //создать нового _______________________________________________________________________________
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("peoples", new Person());
        return "user-create";
    }

    @PostMapping("/new_Create")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors())
            return "allUsers";

        personServis.saveUser(person);
        return "redirect:/";
    }

    //ОБНОВИТЬ по id _______________________________________________________________________________

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("peoples", personServis.findById(id));
        return "user-update";
    }

        @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("peoples") @Valid Person person,BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/user-update";

        person.setId(id);
        personServis.update(person, id);
        return "redirect:/";
    }

    //УДАЛИТЬ по id _______________________________________________________________________________

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        personServis.deleteUser(id);
        return "redirect:/";
    }
}
