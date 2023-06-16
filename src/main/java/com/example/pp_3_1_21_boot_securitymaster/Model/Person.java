package com.example.pp_3_1_21_boot_securitymaster.Model;

import jakarta.persistence.*;
import lombok.Data;

//import javax.validation.constraints.*;


//@Data
// обозначает что по умолчанию будут сгенирированы автоматически и ареализованы  GETor and SETTTor и конструкторы
@Entity // обозначает что данный объект (сущность) связанна с БД
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @Pattern(regexp = "^[a-zA-Z-А-аЯ-я]+$", message = " английские буквы")
//    @NotEmpty(message = "Name should not be empty")
//    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @NotBlank(message = "Email is mandatory")
//    @Email(message = "Email should be valid")
//    @Column(name = "email")
//    private String email;
//
//    @Min(value = 0, message = "Age should be greater than 0")
//    @Column(name = "age")
//    private int age;

    public Person() {

    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}