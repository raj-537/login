package com.dcbbank.SpringSecEx.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcbbank.SpringSecEx.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import java.util.*;

@RestController
public class StudentController {
    List<Student> students=new ArrayList<>(List.of(new Student(1, "raj", 90),
    new Student(2,"Tara",56)));
   @GetMapping("/students")
   public List<Student> getStudent(){
      return students;
   }
   @GetMapping("/csrf-token")
   public CsrfToken getCsrfToken(HttpServletRequest request){
       return (CsrfToken)request.getAttribute("_csrf");
   }

   @PostMapping("/students")
   public Student addStudent(@RequestBody Student student )
   {
    students.add(student);
    return student;
   }
}
