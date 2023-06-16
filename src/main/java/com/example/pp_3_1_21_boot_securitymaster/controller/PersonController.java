package com.example.pp_3_1_21_boot_securitymaster.controller;

import com.example.pp_3_1_21_boot_securitymaster.model.Person;
import com.example.pp_3_1_21_boot_securitymaster.servis.PersonServis;
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
//        List<Person> persons = personServis.findAll();
//        model.addAttribute("peoples", persons);
        model.addAttribute("peoples", personServis.findAll());
        return "allUsers";
    }

    //создать нового _______________________________________________________________________________
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("peoples", new Person());
        return "user-create";
    }

    //    @PostMapping("/user-create")
//    public String create(Person person) {
//        personServis.saveUser(person);
//        return "redirect:/";
//    }
    @PostMapping("/new-create")
    public String create(@ModelAttribute("person") @Validated Person person, BindingResult result) {
        if (result.hasErrors())
            return "redirect:/new-create";

        personServis.saveUser(person);
        return "redirect:/";
    }

    //прочитать по id _______________________________________________________________________________
//    @GetMapping("/{id}")
//    public String read(@PathVariable("id") int id, Model model) {
//        model.addAttribute("users", personServis.readUser(id));
//        return "show";
//    }


    //ОБНОВИТЬ по id _______________________________________________________________________________

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("peoples", personServis.findById(id));
        return "user-update";
    }

//    @PatchMapping("/update/{id}")
//    public String updateUser(Person person) {
//        personServis.saveUser(person);
//        return "redirect:/";
//    }
        @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("peoples") @Validated Person person,BindingResult bindingResult, @PathVariable("id") Long id) {
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
