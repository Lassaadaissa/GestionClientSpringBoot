package com.lassaad.javalabs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lassaad.javalabs.entities.Person;

public interface IPersonRepository extends JpaRepository<Person, Long>{
	
	public List<Person> getByName(String name);
	public List<Person> getByFamilyName(String familyName);

}
