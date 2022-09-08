package com.trickspy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trickspy.model.Student;
import com.trickspy.rest.StudentExceptionHandler;
import com.trickspy.rest.StudentResponseErrorModel;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
 @GetMapping("/studentlist")
	public List<Student> getStudentList(){
	 
	 List<Student> list = new ArrayList<>();
	 
	 list.add(new Student("Sourav","Kumar"));
	 list.add(new Student("Prerana","Kumari"));
	 
	 return list;
	 
 }
 
 
 @GetMapping("student/{studentId}")
 public Student getStudentById(@PathVariable int studentId) {
 List<Student> list = new ArrayList<>();
	 
	 list.add(new Student("Sourav","Kumar"));
	 list.add(new Student("Prerana","Kumari"));

	 if(studentId>list.size()) {
		 throw new StudentExceptionHandler("Student id " + studentId + "Not Found");
	 }
	 return list.get(studentId);
 }
 

	

}
