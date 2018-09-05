package com.lassaad.javalabs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lassaad.javalabs.entities.Person;
import com.lassaad.javalabs.repositories.IPersonRepository;

@RestController
@RequestMapping(value="/v1/person")
public class PersonController {
	
	@Autowired 
	private IPersonRepository personRepo;

	@PostMapping(value="/create")
	public Person createPerson(@RequestBody Person person)  
	{
		return personRepo.save(person);	
	}
	
	
	@PutMapping(value="/update/{id}") 
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person)
	{
		if (id != null) {
			Person p = personRepo.findOne(id);			
		if (p != null) {
			person.setIdPerson(id);
			return personRepo.save(person);
		}
		}
		return null;
	}
	
	
	@DeleteMapping(value="/delete/{id}") 
	public void deletePerson(@PathVariable Long id)
	{
		if(id != null)
		{
			Person person = personRepo.findOne(id);
			if(person != null)
			{
				personRepo.delete(id);
			}
			}
	}
	
	@GetMapping(value="/all")
	public List<Person> getAll()
	{
		return personRepo.findAll(); 
	}
	
	@GetMapping(value="all/by/name/{name}")
	public List<Person> getByName(@PathVariable String name){
		return personRepo.getByName(name);	
	}
	
	@GetMapping(value="all/by/familyname/{familyname}")
	public List<Person> getByFamilyName(@PathVariable String familyname){
		return personRepo.getByFamilyName(familyname);	
	}
	
	@GetMapping(value="/all/params")
	public List<Person> getPersons(String param1, String param2, Integer param3, Boolean param4)
	{
		return personRepo.findAll();
	}
}
