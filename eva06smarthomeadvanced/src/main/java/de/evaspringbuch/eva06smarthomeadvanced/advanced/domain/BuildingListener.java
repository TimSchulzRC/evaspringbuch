package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingListener {
	private static final Logger log = LoggerFactory.getLogger(BuildingListener.class);
	 
	@PrePersist
	public void methodInvokedBeforePersist(Building building) {
		log.info("   >>>   Before persist operation on building with id = {}", building.getId());
	}
 
	@PostPersist
	public void methodInvokedAfterPersist(Building building) {
		log.info("   >>>   After persist operation on building with id = {}", building.getId());
	}
 
	@PreUpdate
	public void methodInvokedBeforeUpdate(Building building) {
		log.info("   >>>   Before update operation on building with id = {}", building.getId());
	}
 
	@PostUpdate
	public void methodInvokedAfterUpdate(Building building) {
		log.info("   >>>   After update operation on building with id = {}", building.getId());
	}
 
	@PreRemove
	private void methodInvokedBeforeRemove(Building building) {
		log.info("   >>>   Before remove operation on building with id = {}", building.getId());
	}
 
	@PostRemove
	public void methodInvokedAfterRemove(Building building) {
		log.info("   >>>   After remove operation on building with id = {}", building.getId());
	}
}
