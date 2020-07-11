package com.hg.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hg.microservices.models.Student;
import com.hg.microservices.services.PersonService;
import com.hg.microservices.services.StudentService;

@RestController
@RequestMapping("/api/colegio")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/estudiante")
	public Student createStudent(@Validated @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/estudiantes")
	public List<Student> readStudents(){
		return studentService.getAllStudents();
	}
	
	@PutMapping("/estudiante/{id}")
	public Student updateStudent(@PathVariable String id, @Validated @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/estudiante/{id}")
	public void deleteStudent(@PathVariable String id) {
		personService.deletePerson(id);
	}
}
