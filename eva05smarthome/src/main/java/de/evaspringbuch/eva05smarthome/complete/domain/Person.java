package de.evaspringbuch.eva05smarthome.complete.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public Person addOwnedBuildings(Building building) {
		this.ownedBuildings.add(building);
		return this;
	}

	public Integer getId() {
		return id;
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
