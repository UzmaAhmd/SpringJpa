package com.example15.App.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

   // *  This annotation used for representing the java class in terms of database table.
   @Entity
    public class StudentDetails
    {
        /**
         * This annotation is used for declaring primary key inside table
         */
        @Id
        /* This annotation is used for generating the values of primary key */
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String firstName;
        private String lastName;
        private String email;

        // No Argument Constructor
        public StudentDetails()
        {

        }
        // All Argument Constructor
        public StudentDetails(Long id, String firstName,
                              String lastName,String email)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName  = lastName;
            this.email = email;
        }

        // Getters And Setters
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
}
