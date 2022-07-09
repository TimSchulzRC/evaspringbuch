package de.evaspringbuch.eva05smarthome.complete.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity 
public class Building implements Serializable { 

	@Id
	@GeneratedValue
	private Integer id; 

	@OneToMany 
	private List<Room> rooms;

	@OneToOne 
	private Address address;

	@ManyToMany(mappedBy = "ownedBuildings") 
	private List<Person> owners;

	public Building() { 
		this.rooms = new ArrayList<>();
		this.owners = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public Building addRoom(Room room) {
		this.rooms.add(room);// .add(room);
		return this;
	}

	public Building withAddress(Address address) {
		this.address = address;
		return this;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public Building addOwner(Person owner) {
		this.owners.add(owner);
		return this;
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
        Building other = (Building) obj;
        return getId() != null && getId().equals(other.getId());
    }
}
