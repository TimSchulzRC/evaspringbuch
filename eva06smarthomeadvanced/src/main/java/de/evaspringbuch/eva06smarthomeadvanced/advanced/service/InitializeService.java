package de.evaspringbuch.eva06smarthomeadvanced.advanced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Address;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.AddressRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.BuildingRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Person;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonInHouse;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonInHouseRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Room;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.RoomRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.Gender;

@Service
public class InitializeService {
	
	private static final Logger log = LoggerFactory.getLogger(InitializeService.class);

    @Autowired
    private PersonInHouseRepository personInHouseRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    
    @Transactional
    public void initMichael() {

        Person personMichael = new Person();
        personMichael.setName("Michael");

        Address addressBerlin = new Address("Berlin");

        Building buildingGreat = new Building();
        buildingRepository.save(buildingGreat);

        personRepository.save(personMichael);
        addressRepository.save(addressBerlin);

        buildingGreat.withAddress(addressBerlin);
        buildingGreat.addOwner(personMichael);
        personMichael.addOwnedBuildings(buildingGreat);
        Room livingRoom = new Room("Wohnzimmer Berlin");
        Room hall = new Room("Flur Berlin");
        Room bedroom = new Room("Schlafzimmer Berlin");
        Room kitchen = new Room("Kueche Berlin");
        Room bathroom = new Room("Badezimmer Berlin");
        Room childrenroom1 = new Room("Kinderzimmer Berlin");
        Room childrenroom2 = new Room("Kinderzimmer Berlin");

        hall.addRoom(livingRoom).addRoom(bedroom).addRoom(kitchen).addRoom(bathroom)
            .addRoom(childrenroom1).addRoom(childrenroom2);


        buildingGreat.addRoom(livingRoom).addRoom(hall).addRoom(bedroom)
                .addRoom(bathroom).addRoom(kitchen).addRoom(childrenroom1)
                .addRoom(childrenroom2);

//        roomRepository.save(livingRoom);
//        roomRepository.save(hall);
//        roomRepository.save(bedroom);
//        roomRepository.save(bathroom);
//        roomRepository.save(kitchen);
//        roomRepository.save(childrenroom1);
//        roomRepository.save(childrenroom2);

        PersonInHouse personInHouse = new PersonInHouse().withPerson(personMichael);

        personInHouseRepository.save(personInHouse);

        personInHouse.withBuilding(buildingGreat);
        personInHouse.withRoom(hall);

        
        ////////////////
        Address addressKoeln = new Address("Koeln");

        Building buildingSmall = new Building();
        buildingRepository.save(buildingSmall);

        personRepository.save(personMichael);
        addressRepository.save(addressKoeln);

        buildingSmall.withAddress(addressKoeln);
        buildingSmall.addOwner(personMichael);
        personMichael.addOwnedBuildings(buildingSmall);
        hall = new Room("Flur Koeln");
        livingRoom = new Room("KuecheWohnzimmer Koeln");
        bedroom = new Room("Schlafzimmer");
        bathroom = new Room("Badezimmer Koeln");
        Room childrenroom = new Room("Kinderzimmer Koeln");

        hall.addRoom(livingRoom).addRoom(childrenroom);
        livingRoom.addRoom(bedroom).addRoom(bathroom);

        buildingSmall.addRoom(livingRoom).addRoom(hall).addRoom(bedroom)
                .addRoom(bathroom).addRoom(childrenroom);

//        roomRepository.save(livingRoom);
//        roomRepository.save(hall);
//        roomRepository.save(bedroom);
//        roomRepository.save(bathroom);
//        roomRepository.save(childrenroom);
        
    }

    @Transactional
    public void initLaura() {
        Person personLaura = new Person();
        personLaura.setName("Laura");
        personRepository.save(personLaura);

        Building buildingGreat = buildingRepository.findById(1).get();
        buildingGreat.addOwner(personLaura);
        personLaura.addOwnedBuildings(buildingGreat);
        PersonInHouse personInHouse = new PersonInHouse().withPerson(personLaura);

        personInHouseRepository.save(personInHouse);
        personInHouse.withBuilding(buildingGreat);
        List<Room> rooms = buildingGreat.getRooms();
        Room room = rooms.stream().filter(r -> r.getName().equals("Wohnzimmer Berlin")).findFirst().get();

        Building b = buildingRepository.findByAddressCity("Berlin");
//        List<Building> b = buildingRepository.findBuildingWithTheRoom(room);
//        Building b = buildingRepository.findBuildingByRoomsAndFindRoomsByName(room, "Schlafzimmer Berlin");

        personInHouse.withRoom(room);

    }

    @Transactional
    public void initToni() {
    	Person personToniM = new Person();
	   	 personToniM.setName("Toni");
	   	 personToniM.setGender(Gender.male);
	   	 personRepository.save(personToniM);
    }

    
    @Transactional
    public void initKarl() {

        Person personKarl = new Person();
        personKarl.setName("Karl");

        Address addressHamburg = new Address("Hamburg");

        Building buildingSmall = new Building();
        buildingRepository.save(buildingSmall);

        personRepository.save(personKarl);
        addressRepository.save(addressHamburg);

        buildingSmall.withAddress(addressHamburg);
        buildingSmall.addOwner(personKarl);
        personKarl.addOwnedBuildings(buildingSmall);
        Room livingRoom = new Room("Wohnzimmer Hamburg");
        Room hall = new Room("Flur Hamburg");
        Room bedroom = new Room("Schlafzimmer Hamburg");
        Room kitchen = new Room("Kueche Hamburg");
        Room bathroom = new Room("Badezimmer Hamburg");
        Room childrenroom = new Room("Kinderzimmer Hamburg");

        kitchen.addRoom(hall).addRoom(bathroom);
        hall.addRoom(livingRoom).addRoom(bedroom);

        buildingSmall.addRoom(livingRoom);
        buildingSmall.addRoom(hall);
        buildingSmall.addRoom(bedroom);
        buildingSmall.addRoom(bathroom);
        buildingSmall.addRoom(kitchen);
        buildingSmall.addRoom(childrenroom);

        roomRepository.save(livingRoom);
        roomRepository.save(hall);
        roomRepository.save(bedroom);
        roomRepository.save(bathroom);
        roomRepository.save(kitchen);
        roomRepository.save(childrenroom);

        PersonInHouse personInHouse = new PersonInHouse().withPerson(personKarl);

        personInHouseRepository.save(personInHouse);

        personInHouse.withBuilding(buildingSmall);
        personInHouse.withRoom(hall);
    }



    @Transactional
    public void initAnna() {

        Person personAnna = new Person();
        personAnna.setName("Anna");

        Address addressMuenchen = new Address("Muenchen");

        Building buildingSmall = new Building();
        buildingRepository.save(buildingSmall);

        personRepository.save(personAnna);
        addressRepository.save(addressMuenchen);

        buildingSmall.withAddress(addressMuenchen);
        buildingSmall.addOwner(personAnna);
        personAnna.addOwnedBuildings(buildingSmall);
        Room livingRoom = new Room("Wohn+Kueche Muenchen");
        Room bedroom = new Room("Schlafzimmer");
        Room bathroom = new Room("Badezimmer Muenchen");

        livingRoom.addRoom(bedroom).addRoom(bathroom);

        buildingSmall.addRoom(livingRoom).addRoom(bedroom).addRoom(bathroom);

        roomRepository.save(livingRoom);
        roomRepository.save(bedroom);
        roomRepository.save(bathroom);

        PersonInHouse personInHouse = new PersonInHouse().withPerson(personAnna);

        personInHouseRepository.save(personInHouse);

        personInHouse.withBuilding(buildingSmall);
        personInHouse.withRoom(livingRoom);
    }

    @Transactional
    public void testQueries() {

//        Person person = personRepository.findByName("Laura");
//        System.out.println("test :: " + person.getName());
//        person = personRepository.findByNameStartingWith("Lau");
//        System.out.println("test :: " + person.getName());
//        int i = personRepository.countByNameStartingWith("Lau");
//
////        uilding b = buildingRepository.findWat(room);
//        List<Room> r = buildingRepository.findRoomInBuilding("Schlafzimmer");
//
//        r.forEach(ro -> log.info("            " + ro.getId() + " // " + ro.getName() ));
//
//        Building b = buildingRepository.searchTheBuildingAtAddress("Berlin");
        
    }

	@Transactional
	public void tryLazyEagerLoading() {
	    Person person = personRepository.findByName("Laura");
	    person.getOwnedBuildings().size();
	    log.info("testLazyEagerLoading :: " + person.getOwnedBuildings());
	}

	@Transactional
	public void tryDeleteBuilding() {
	    Building building = buildingRepository.findById(1).get();
//	    List<PersonInHouse> personInHouseList = personInHouseRepository.findByBuilding(building);
//	    personInHouseList.forEach(p -> {
//	            personInHouseRepository.delete(p);
//	            //    building.getOwners().forEach(o -> o.removeBuilding(building));
//	    	}
//	    );
	    buildingRepository.delete(building);
	    log.info("testDeleteBuilding :: " + building.getId());
	}

	@Transactional 
    public void tryEntiylistener1() {

        Building building = new Building();
        building = buildingRepository.save(building);
    }

    @Transactional 
    public void tryEntiylistener2() {
        Building building = buildingRepository.findById(1).get();
        Address address = new Address("Stuttgart");
        addressRepository.save(address);
        building.withAddress(address);  
//        buildingRepository.save(building);
    }

    @Transactional 
    public void tryEntiylistener3() {
    	Building building = buildingRepository.findById(1).get();
        buildingRepository.delete(building);
    }
	
}
