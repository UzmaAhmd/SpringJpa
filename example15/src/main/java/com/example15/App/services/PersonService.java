package com.example15.App.services;

import com.example15.App.domain.Person;
import com.example15.App.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class PersonService {

        @Autowired
        private PersonRepository repository;

        // Save a new Person to the database
        public Person save(Person person) {
            return repository.save(person);
        }

        // Fetch all Persons from the database
        public List<Person> getAllPersons() {
            return repository.findAll();
        }

        // Fetch a single Person by ID
        public Person getPersonById(Long id) {
            Optional<Person> optionalPerson = repository.findById(id);
            if (optionalPerson.isPresent()) {
                return optionalPerson.get();
            }
            return null; // or throw a custom exception if preferred
        }

        // Delete a Person by ID
        public void deletePerson(Long id) {
            repository.deleteById(id);
        }

        // Update an existing Person by ID
        public Person update(Long id, Person person) {
            Optional<Person> optionalPerson = repository.findById(id);

            if (optionalPerson.isPresent()) {
                Person existingPerson = optionalPerson.get();

                existingPerson.setFirstName(person.getFirstName());
                existingPerson.setLastName(person.getLastName());
                existingPerson.setAge(person.getAge());

                return repository.save(existingPerson);
            }

            return null;
        }
    }
