package com.hg.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hg.microservices.models.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

}
