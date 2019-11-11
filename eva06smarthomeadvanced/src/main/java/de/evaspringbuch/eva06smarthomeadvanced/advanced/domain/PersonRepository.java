package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.Gender;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);
    Person findByNameStartingWith(String name);
//    List<Person> findByNameStartingWith(String name);
    int countByNameStartingWith(String name);
    Person findByNameAndGender(String lastname, Gender gender);
}
