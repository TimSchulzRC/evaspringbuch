package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// InheritanceType.SINGLE_TABLE, InheritanceType.TABLE_PER_CLASS; InheritanceType.JOINED
//@EntityListeners(BuildingListener.class)
public class Building implements Serializable {

    @Id @GeneratedValue//(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<Room>();

    @OneToOne
    private Address address;

    @ManyToMany(mappedBy = "ownedBuildings")
    private List<Person> owners = new ArrayList<>();

    public Building() {
//        this.rooms = new ArrayList<>();
//        this.owners = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Address getAddress() {
        return address;
    }

    public Building addRoom(Room room) {
        this.rooms.add(room);
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

	@Override
	public String toString() {
		return "Building [id=" + id + ", rooms=" + rooms + ", address=" + address + ", owners=" + owners + "]";
	}
    
    
}

