package com.example15.App.services;


import com.example15.App.domain.StudentDetails;
import com.example15.App.repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailsService
{
    @Autowired
    StudentDetailsRepository repository;


    // Save The Java StudentDetails Object Into Database table
    public StudentDetails save (StudentDetails studentDetails)
    {
        StudentDetails savedStudent =  repository.save(studentDetails);
        return savedStudent;
    }



    // Fetch all StudentDetails records from the database
    public List<StudentDetails> getListOfStudents()
    {
        // Returns all student_details records from database table in the form of list
        List<StudentDetails> studentDetailsList = repository.findAll();
        return studentDetailsList;
    }




    public StudentDetails getStudentById(Long studentId)
    {
        Optional<StudentDetails> studentDetailsOptional = repository.findById(studentId);

        StudentDetails data = null;

        if(studentDetailsOptional.isPresent())
        {
            data = studentDetailsOptional.get();
        }

        return data;
    }


    public void deleteStudent(Long id)
    {
        repository.deleteById(id);
    }




    public StudentDetails update(Long id, StudentDetails studentDetails)
    {

        // select * from student_details where id= 3;
        Optional<StudentDetails> studentOptional =  repository.findById(id);

        if(studentOptional.isPresent())
        {
            StudentDetails student = studentOptional.get();

            String newEmail = studentDetails.getEmail();
            student.setEmail(newEmail);

            String newFirstName = studentDetails.getFirstName();
            student.setFirstName(newFirstName);

            String newLastName = studentDetails.getLastName();
            student.setLastName(newLastName);

            student =  repository.save(student);
            return student;
        }

        return null;
    }
}