package de.evaspringbuch.eva05smarthome.complete.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private String city;

	@OneToOne(mappedBy = "address")
	private Building building;

	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public Address(String city) {
		this.city = city;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
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
        Address other = (Address) obj;
        return getId() != null && getId().equals(other.getId());
    }
}
