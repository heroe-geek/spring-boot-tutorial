package com.hg.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hg.microservices.models.Student;
import com.hg.microservices.repositories.IStudentRepository;

@Service
public class StudentService {

	@Autowired
	private IStudentRepository iStudentRepository;
	
	public Student saveStudent(Student student) {
		return iStudentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return iStudentRepository.findAll();
	}
}
