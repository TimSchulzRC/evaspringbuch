package de.evaspringbuch.eva05smarthome.complete.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public Room(String name) {
		this.name = name;
	}

	public Room() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Room addName(String name) {
		this.name = name;
		return this;
	}

	public Room addPersonInHouse(PersonInHouse personInHouse) {
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
