package com.example.demo.repo;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Person;

public interface PersonRepository {
public Person createPerson(Person person);
	
	public Collection<Person> getAllPersons();
	
	public Person getPeresonByIdPerson(Integer personId);
	public Person updatePersonById(Integer personId,Person person);
	public Person updatePersonByName(String firstname,Person person);
	
	public Person findByName(String firstname);
	
	public Person findByLastName(String lastname);
	public Person findByEmail(String email);
	public Person updatePersonByLastName(String lastname,Person person);
	public Person updatePersonByEmail(String email,Person person);
	
	public Person deleteById(int id);



}


