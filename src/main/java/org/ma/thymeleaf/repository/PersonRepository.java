package org.ma.thymeleaf.repository;

import org.ma.thymeleaf.entitie.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@RepositoryRestResource
@CrossOrigin("*")
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
