package com.hg.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hg.microservices.models.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, String>{

}
