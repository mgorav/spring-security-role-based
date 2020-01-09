package com.gonnect.spring.security.authorization.api;

import com.gonnect.spring.security.authorization.entity.Person;
import com.gonnect.spring.security.authorization.exception.PersonNotFoundException;
import com.gonnect.spring.security.authorization.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class PersonApis {

    private final PersonRepository personRepository;


    @GetMapping("/persons")
    List<Person> findAll() {

        return personRepository.findAll();
    }


    //Save
    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }


    // Find
    @GetMapping("/persons/{id}")
    Person findById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " no found."));
    }

    // Save or Update
    @PutMapping("/persons/{id}")
    Person upsert(@RequestBody Person newPerson, @PathVariable Long id) {

        return personRepository.findById(id)
                .map(p -> {
                    p.setFirstName(newPerson.getFirstName());
                    p.setLastName(newPerson.getLastName());
                    p.setPhoneNumber(newPerson.getPhoneNumber());
                    return personRepository.save(newPerson);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });

    }

    // Delete
    @DeleteMapping("/persons/{id}")
    void delete(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
