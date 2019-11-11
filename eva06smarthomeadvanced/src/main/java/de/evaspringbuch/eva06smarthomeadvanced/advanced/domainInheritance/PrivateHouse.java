package de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance;

import javax.persistence.Entity;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;

@Entity
public class PrivateHouse extends Building {

    private int children;

    public PrivateHouse() {
    }

    public PrivateHouse withChildren(int children) {
        this.children = children;
        return this;
    }
}
