package com.example.demo.repo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
	
private Map<Integer,Person> persons=null;
	
	{
		persons=new HashMap<Integer,Person>();
	}
	

	@Override
	public Person createPerson(Person person) {

		// TODO Auto-generated method stub
		persons.put(person.getPersonId(),person);
		return person;
	}

	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return persons.values();
	}
	
	@Override
	public Person getPeresonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		Person thePerson=persons.get(personId);
		
		System.out.println(thePerson);
		if(thePerson==null )
		{
			return null;
		}
		else
			return thePerson;
		

	}
	
	@Override
	public Person updatePersonById(Integer personId, Person person) {
		// TODO Auto-generated method stub
		Person thePerson = persons.get(personId);

		if (thePerson == null) {
			return null;
		} else
			thePerson.setFirstName(person.getFirstName());
		thePerson.setLastName(person.getLastName());
		thePerson.setEmail(person.getEmail());
		return thePerson;

		
	}

	
	public Person updatePersonByName(String firstName, Person newPerson) {
		// TODO Auto-generated method stub
		Person p = findByName(firstName);
		if (p!=null) {
			
			p.setFirstName(newPerson.getFirstName());
			p.setLastName(newPerson.getLastName());
			p.setEmail(newPerson.getEmail());
		}
		return p;
		
		
	}

	@Override
	public Person findByName(String firstname) {
		Person returnPerson = null;
		// TODO Auto-generated method stub
		Collection<Person> findpersonsbyname = persons.values();
		for(Person p: findpersonsbyname) {
			if(p.getFirstName().equals(firstname)) {
				 returnPerson = p;
				 break;
			}
			System.out.println(returnPerson);
		}
		return returnPerson;
		
	}

	
	@Override
	public Person findByLastName(String Lastname) {
		Person returnPerson = null;
		// TODO Auto-generated method stub
		Collection<Person> findpersonsbyname = persons.values();
		for(Person p: findpersonsbyname) {
			if(p.getLastName().equals(Lastname)){
				 returnPerson = p;
				 break;
			}
			System.out.println(returnPerson);
		}
		return returnPerson;
		
	}
	public Person updatePersonByLastName(String lastname, Person newPerson) {
		// TODO Auto-generated method stub
		Person p = findByLastName(lastname);
		if (p!=null) {
			
			p.setFirstName(newPerson.getFirstName());
			p.setLastName(newPerson.getLastName());
			p.setEmail(newPerson.getEmail());
		}
		return p;
		
		
	}

	@Override
	public Person findByEmail(String email) {
		Person returnPerson = null;
		// TODO Auto-generated method stub
		Collection<Person> findpersonsbyemail = persons.values();
		for(Person p: findpersonsbyemail) {
			if(p.getEmail().equals(email)){
				 returnPerson = p;
				 break;
			}
			System.out.println(returnPerson);
		}
		return returnPerson;
		
	}

	@Override
	public Person updatePersonByEmail(String email, Person newPerson) {
		// TODO Auto-generated method stub
		Person p = findByEmail(email);
		if (p!=null) {
			
			p.setFirstName(newPerson.getFirstName());
			p.setLastName(newPerson.getLastName());
			p.setEmail(newPerson.getEmail());
		}
		return p;
	}

	@Override
	public Person deleteById(int id) {
		Person returnPerson = null;
		// TODO Auto-generated method stub
		Collection<Person> findpersonsbyid = persons.values();
		for(Person p: findpersonsbyid) {
			if(p.getPersonId()== id){
				returnPerson = p;
				findpersonsbyid.remove(p);
				 break;
			}
		}
		return returnPerson;
		
	}

}