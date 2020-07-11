package com.hg.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hg.microservices.models.Course;
import com.hg.microservices.repositories.ICourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private ICourseRepository iCourseRepository;
	
	public Course saveCourse(Course course) {
		return iCourseRepository.save(course);
	}
	
	public List<Course> getAllCourses(){
		return iCourseRepository.findAll();
	}
	
	public void deleteCourse(Long id) {
		iCourseRepository.deleteById(id);
	}

}
