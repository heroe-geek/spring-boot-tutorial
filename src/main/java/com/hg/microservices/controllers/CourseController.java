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

import com.hg.microservices.models.Course;
import com.hg.microservices.services.CourseService;

@RestController
@RequestMapping("/api/colegio")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/curso")
	public Course createCourse(@Validated @RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@GetMapping("/cursos")
	public List<Course> readCourses(){
		return courseService.getAllCourses();
	}
	
	@PutMapping("/curso/{id}")
	public Course updateCourse(@PathVariable String id, @Validated @RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@DeleteMapping("/curso/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}

}
