package com.example15.App.controller;

import com.example15.App.domain.StudentDetails;
import com.example15.App.services.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/studentDetails/")
public class StudentDetailsController
{
    @Autowired
    StudentDetailsService studentDetailsService;


    // POST http://localhost:8080/api/v1/studentDetails/create
    @PostMapping("create")
    StudentDetails createStudentDetails(@RequestBody StudentDetails studentDetails)
    {
        StudentDetails savedStudent =  studentDetailsService.save(studentDetails);
        return studentDetails;
    }





    // GET http://localhost:8080/api/v1/studentDetails/all
    @GetMapping("all")
    List<StudentDetails> getAllStudentDetails()
    {
        List<StudentDetails> studentDetailsList = studentDetailsService.getListOfStudents();
        return studentDetailsList;
    }




    // GET http://localhost:8080/api/v1/studentDetails/{id}
    @GetMapping("{id}")
    StudentDetails getStudentById(@PathVariable("id") Long myStudentId)
    {
        StudentDetails details = studentDetailsService.getStudentById(myStudentId);
        return details;
    }




    //	// DELETE http://localhost:8080/api/v1/studentDetails/{id}
    @DeleteMapping("{id}")
    void deleteStudentById(@PathVariable("id") Long id)
    {
        studentDetailsService.deleteStudent(id);
    }




    // PUT http://localhost:8080/api/v1/studentDetails/{id}
    @PutMapping("{id}")
    StudentDetails updateStudentDetails(@PathVariable("id") Long id, @RequestBody StudentDetails studentDetails)
    {
        StudentDetails updatedStudentDetails =  studentDetailsService.update(id,studentDetails);
        return updatedStudentDetails;
    }
}

//	// PUT http://localhost:8080/api/v1/studentDetails/{id}
//	@PutMapping("{id}")
//	StudentDetails updateStudentDetails(@PathVariable("id") Long id, @RequestBody StudentDetails studentDetails)
//	{
//
//	}



//	// PATCH http://localhost:8080/api/v1/studentDetails/{id}
//	@PatchMapping("{id}")
//	StudentDetails partialUpdateStudentDetails(@PathVariable("id") Long id, @RequestBody StudentDetails studentDetails)
//	{
//
//	}

