package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.Gender;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

	@ManyToMany
    private List<Building> ownedBuildings;

    public Person() {
        this.ownedBuildings = new ArrayList<>();
    }

    public List<Building> getOwnedBuildings() {
        return ownedBuildings;
    }

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Integer getId() {
		return id;
	}
    
    public Person addOwnedBuildings(Building building) {
        this.ownedBuildings.add(building);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeBuilding(Building building) {
        this.ownedBuildings.remove(building);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        Person other = (Person) obj;
        return getId() != null && getId().equals(other.getId());
    }
}
