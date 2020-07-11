package com.hg.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hg.microservices.repositories.IPersonRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonRepository iPersonRepository;
	
	public void deletePerson(String id) {
		iPersonRepository.deleteById(id);
	}
}
