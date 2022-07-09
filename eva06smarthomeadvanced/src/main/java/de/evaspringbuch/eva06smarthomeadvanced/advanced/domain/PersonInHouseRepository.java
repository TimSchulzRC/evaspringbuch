package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInHouseRepository extends JpaRepository<PersonInHouse, Integer> {

    List<PersonInHouse> findByBuilding(Building building);
}
