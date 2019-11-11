package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonInHouseRepository extends JpaRepository<PersonInHouse, Integer> {

    List<PersonInHouse> findByBuilding(Building building);
}
