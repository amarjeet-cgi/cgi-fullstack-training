package com.example.demo.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	

	
	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		return personRepository.createPerson(person);
	}

	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.getAllPersons();
	}
	
	@Override
	public Person getPeresonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		
		return personRepository.getPeresonByIdPerson(personId);
		
	}
	
	@Override
	public Person updatePersonById(Integer personId, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonById(personId, person);
	}

	@Override
	public Person updatePersonByName(String firstName, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonByName(firstName, person);
	}

	@Override
	public Person findByName(String firstname) {
		// TODO Auto-generated method stub
		return personRepository.findByName(firstname);
	}

	@Override
	public Person findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return personRepository.findByLastName(lastname);
	}

	@Override
	public Person updatePersonByLastName(String lastname, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonByLastName(lastname, person);
	}

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		return personRepository.findByEmail(email);
	}

	@Override
	public Person updatePersonByEmail(String email, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonByEmail(email, person);
	}

	@Override
	public Person deleteById(int id) {
		// TODO Auto-generated method stub
		return personRepository.deleteById(id);
	}
	
	

}