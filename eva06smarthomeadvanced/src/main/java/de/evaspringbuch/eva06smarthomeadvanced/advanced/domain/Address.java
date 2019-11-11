package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address implements Serializable {

    @Id @GeneratedValue
    private Integer id;

    private String city;

    @Embedded
    private AdvancedAddress advancedAddress = new AdvancedAddress();

    @OneToOne(mappedBy = "address")
    Building building;

    public Address() {
    }

    public Address(String city) {
        this.setCity(city);
    }

	public Integer getId() {
		return id;
	}
	
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setAdvancedAddress(String zipCode, String street) {
        this.advancedAddress.setZipcode(zipCode);
        this.advancedAddress.setStreet(street);
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
