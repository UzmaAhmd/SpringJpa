package com.example15.App.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


    @Entity
    public class Person
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long personId;
        private String firstName;
        private String lastName;
        private Integer age;

        // No Arg And All Args Constructors
        public Person() {
        }

        public Person(Long personId, String firstName, String lastName, Integer age) {
            this.personId = personId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        // Getters And Setters
        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
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

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
}
