package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "room")
    private List<PersonInHouse> personsInHouse = new ArrayList<>();

    @OneToMany
    private List<Room> neighbouringRooms = new ArrayList<>();

//    public void setBuilding(Building building) {
//        this.building = building;
//    }

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Room withName(String name) {
        this.name = name;
        return this;
    }

    public Room withPersonInHouse(PersonInHouse personInHouse) {
        this.personsInHouse.add(personInHouse);
        return this;
    }

    public List<PersonInHouse> getPersonsInHouse() {
        return personsInHouse;
    }

    public Room addRoom(Room room) {
        this.neighbouringRooms.add(room);
        return this;
    }

    public void deletePersonInHouse(PersonInHouse personInHouseHeinz) {
        this.personsInHouse.remove(personInHouseHeinz);
    }
    
    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Room other = (Room) obj;
        return getId() != null && getId().equals(other.getId());
    }
}
