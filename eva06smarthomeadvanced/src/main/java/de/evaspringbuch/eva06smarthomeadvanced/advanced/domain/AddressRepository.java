package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
