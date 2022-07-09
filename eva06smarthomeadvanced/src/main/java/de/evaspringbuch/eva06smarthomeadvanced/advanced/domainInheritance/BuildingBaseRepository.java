package de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;

@NoRepositoryBean
public interface BuildingBaseRepository<T extends Building> extends JpaRepository<T, Integer> {
}
