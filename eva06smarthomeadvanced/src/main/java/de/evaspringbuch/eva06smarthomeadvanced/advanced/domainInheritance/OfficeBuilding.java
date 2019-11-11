package de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance;

import javax.persistence.Entity;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;

@Entity
public class OfficeBuilding extends Building {

    private String sector;

    public OfficeBuilding() {
    }

    public OfficeBuilding withSector(String sector) {
        this.sector = sector;
        return this;
    }
}
