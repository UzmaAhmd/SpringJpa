package com.example15.App.controller;

import com.example15.App.domain.Person;
import com.example15.App.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/person/")
    public class PersonController {

        @Autowired
        PersonService personService;

        // POST http://localhost:8080/api/v1/person/create
        @PostMapping("create")
        public Person createPerson(@RequestBody Person person) {
            return personService.save(person);
        }

        // GET http://localhost:8080/api/v1/person/all
        @GetMapping("all")
        public List<Person> getAllPersons() {
            return personService.getAllPersons();
        }

        // GET http://localhost:8080/api/v1/person/{id}
        @GetMapping("{id}")
        public Person getPersonById(@PathVariable("id") Long id) {
            return personService.getPersonById(id);
        }

        // DELETE http://localhost:8080/api/v1/person/{id}
        @DeleteMapping("{id}")
        public void deletePersonById(@PathVariable("id") Long id) {
            personService.deletePerson(id);
        }

        // PUT http://localhost:8080/api/v1/person/{id}
        @PutMapping("{id}")
        public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
            return personService.update(id, person);
        }
    }