package de.evaspringbuch.eva05smarthome.complete.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
