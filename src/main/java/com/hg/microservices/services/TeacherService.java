package com.hg.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hg.microservices.models.Teacher;
import com.hg.microservices.repositories.ITeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private ITeacherRepository iTeacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		return iTeacherRepository.save(teacher);
	}
	
	public List<Teacher> getAllTeachers(){
		return iTeacherRepository.findAll();
	}

}
