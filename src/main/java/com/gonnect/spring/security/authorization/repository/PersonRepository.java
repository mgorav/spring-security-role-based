package com.gonnect.spring.security.authorization.repository;

import com.gonnect.spring.security.authorization.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
