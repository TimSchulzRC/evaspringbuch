package de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance;

import org.springframework.data.jpa.repository.Query;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Room;

import java.util.List;

public interface BuildingWithInheritanceRepository extends BuildingBaseRepository<Building> {

    @Query("select b from Building b where ?1 = b.address.city")
    Building searchTheBuildingAtAddress(String name);

    Building findByAddressCity(String city);

    @Query("select r from Building b, Room r where r member b.rooms and r.name = ?1")
    List<Room> findRoomInBuilding(String name);

}
