// AQUI SE PONEN LAS @COSAS QUE PERMITEN
// COMUNICACION REST CON EL SERVIDOR

package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import jakarta.validation.Valid;

@RequestMapping("api/v1/person")
@RestController
@CrossOrigin(origins = "*")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
				.orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}

	@PutMapping(path = "{id}")
	public void updatePerson(@PathVariable UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}

}
