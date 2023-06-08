package com.example.demo.Controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PersonService;
import com.example.demo.model.Person;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {

		Person p=personService.createPerson(person);
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@GetMapping("/persons")
	public ResponseEntity<Collection<Person>> getAllPersons() {
		return ResponseEntity.ok().body(personService.getAllPersons());
	}
	
	
	@GetMapping("/persons/{personId}")
	public ResponseEntity<?> getPersonById(@PathVariable("personId") Integer personid)
	{
		Person p=personService.getPeresonByIdPerson(personid);
		System.out.println(p);
		
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: "+personid+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@PutMapping("/persons/{personId}")
	public ResponseEntity<?> updatePerson(@PathVariable("personId") Integer personId, @RequestBody Person person) {
		Person p=personService.updatePersonById(personId, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	

	
	@GetMapping("/persons/name/{firstName}")
	public ResponseEntity<?> getPersonByName(@PathVariable("firstName") String firstname)
	{
		Person p=personService.findByName(firstname);
		System.out.println(p);
		
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with firstname: "+firstname+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@PutMapping("/persons/name/{firstName}")
	public ResponseEntity<?> updatePersonByName(@PathVariable("firstName") String firstname, @RequestBody Person person) {
		Person p=personService.updatePersonByName(firstname, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with name: " + firstname + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	
	@GetMapping("/persons/lastname/{lastName}")
	public ResponseEntity<?> getPersonByLastName(@PathVariable("lastName") String lastname)
	{
		Person p=personService.findByLastName(lastname);
		System.out.println(p);
		
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with firstname: "+lastname+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@PutMapping("/persons/lastname/{lastName}")
	public ResponseEntity<?> updatePersonByLastName(@PathVariable("lastName") String lastname, @RequestBody Person person) {
		Person p=personService.updatePersonByLastName(lastname, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with name: " + lastname + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	@GetMapping("/persons/email/{email}")
	public ResponseEntity<?> getPersonByEmail(@PathVariable("email") String Email)
	{
		Person p=personService.findByEmail(Email);
		System.out.println(p);
		
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email: "+Email+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@PutMapping("/persons/email/{email}")
	public ResponseEntity<?> updatePersonByEmail(@PathVariable("email") String Email, @RequestBody Person person) {
		Person p=personService.updatePersonByEmail(Email, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email: " + Email + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	
	@DeleteMapping("/persons/{personId}")
	public ResponseEntity<?> deleteById(@PathVariable("personId") int personid) {
		Person p=personService.deleteById(personid);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email: " + personid + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}

}