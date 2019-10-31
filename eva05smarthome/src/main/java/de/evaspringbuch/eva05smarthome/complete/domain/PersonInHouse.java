package de.evaspringbuch.eva05smarthome.complete.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PersonInHouse implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	private Person person;

	@ManyToOne
	private Room room;

	@ManyToOne
	private Building building;

	public PersonInHouse() {
	}

	public Integer getId() {
		return id;
	}

	public PersonInHouse withPerson(Person person) {
		this.person = person;
		return this;
	}

	public PersonInHouse withRoom(Room room) {
		this.room = room;
		return this;
	}

	public PersonInHouse leaveRoom(Room room) {
		this.room = null;
		return this;
	}

	public PersonInHouse withBuilding(Building building) {
		this.building = building;
		return this;
	}

	public Room getRoom() {
		return room;
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
        PersonInHouse other = (PersonInHouse) obj;
        return getId() != null && getId().equals(other.getId());
    }
}
