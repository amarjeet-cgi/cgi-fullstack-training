package com.example.demo.Service;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Person;

public interface PersonService {
	
	public Person createPerson(Person person);
	
	public Collection<Person> getAllPersons();
	
	public Person getPeresonByIdPerson(Integer personId);
	
	public Person updatePersonById(Integer personId, Person person);
	public Person deleteById(int id);
	
	public Person updatePersonByName(String name , Person person);

	public Person findByName(String firstname);
	
	public Person findByLastName(String lastname);

	public Person updatePersonByLastName(String lastname,Person person);
	
	public Person findByEmail(String email);
	
	public Person updatePersonByEmail(String email,Person person);
}


	