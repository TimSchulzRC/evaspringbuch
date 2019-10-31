package de.evaspringbuch.eva05smarthome.complete.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva05smarthome.complete.domain.Address;
import de.evaspringbuch.eva05smarthome.complete.domain.AddressRepository;
import de.evaspringbuch.eva05smarthome.complete.domain.Building;
import de.evaspringbuch.eva05smarthome.complete.domain.BuildingRepository;
import de.evaspringbuch.eva05smarthome.complete.domain.Person;
import de.evaspringbuch.eva05smarthome.complete.domain.PersonInHouse;
import de.evaspringbuch.eva05smarthome.complete.domain.PersonInHouseRepository;
import de.evaspringbuch.eva05smarthome.complete.domain.PersonRepository;
import de.evaspringbuch.eva05smarthome.complete.domain.Room;
import de.evaspringbuch.eva05smarthome.complete.domain.RoomRepository;

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
    public void initBuildingAndAddressOne2OneBi() {
        Address addressMichael = new Address("Hamburg");
        addressRepository.save(addressMichael);
        Building buildingMichael = new Building();
        buildingRepository.save(buildingMichael);
        buildingMichael.withAddress(addressMichael);
        addressMichael.setBuilding(buildingMichael);
//        log.info("    >>> :: " + addressMichael.getBuilding());
        Address addressAnna = new Address("Berlin");
        addressRepository.save(addressAnna);
        Building buildingAnna = new Building();
        buildingRepository.save(buildingAnna);
        buildingAnna.withAddress(addressAnna);
        addressAnna.setBuilding(buildingAnna);
    }

    @Transactional
    public void initPersonInHouseAndPersonOne2OneUni() {
        Person personMichael = new Person();
        personMichael.setName("Michael");
        personRepository.save(personMichael);
        PersonInHouse personInHouse = new PersonInHouse().withPerson(personMichael);
        personInHouseRepository.save(personInHouse);
    }
    
	@Transactional
	public void initBuildingAndPersonMany2ManyBi() {
	    Building buildingGreat = new Building();
	    buildingRepository.save(buildingGreat);
	    Building buildingSmall = new Building();
	    buildingRepository.save(buildingSmall);
	    Person personMichael = new Person();
	    personMichael.setName("Michael");
	    personRepository.save(personMichael);
	    Person personLaura = new Person();
	    personLaura.setName("Laura");
	    personRepository.save(personLaura);
	    Person personAnna = new Person();
	    personAnna.setName("Anna");
	    personRepository.save(personAnna);
	    buildingGreat.addOwner(personMichael).addOwner(personLaura);
	    buildingSmall.addOwner(personAnna).addOwner(personMichael);
	    personMichael.addOwnedBuildings(buildingGreat).addOwnedBuildings(buildingSmall);
	    personAnna.addOwnedBuildings(buildingSmall);
	    personLaura.addOwnedBuildings(buildingGreat);
	}

    @Transactional
    public void initBuildingAndRoomOne2ManyUni() {
        Building building = new Building();
        buildingRepository.save(building);
        Room livingRoom = new Room("Wohnzimmer");
        Room hall = new Room("Flur");
        Room bedroom = new Room("Schlafzimmer");
        buildingRepository.save(building);
        building.addRoom(hall).addRoom(livingRoom).addRoom(bedroom);
//        livingRoom.setBuilding(building);
//        hall.setBuilding(building);
//        bedroom.setBuilding(building);
        roomRepository.save(livingRoom);
        roomRepository.save(hall);
        roomRepository.save(bedroom);
    }

    @Transactional
    public void initPersonInHouseAndBuildingMany2OneUni() {
        Person personMichael = new Person();
        personMichael.setName("Michael");
        personRepository.save(personMichael);
        PersonInHouse personInHouseMichael = new PersonInHouse().withPerson(personMichael);
        personInHouseRepository.save(personInHouseMichael);
        Person personKarl = new Person();
        personKarl.setName("Karl");
        personRepository.save(personKarl);
        PersonInHouse personInHouseKarl = new PersonInHouse().withPerson(personKarl);
        personInHouseRepository.save(personInHouseKarl);
        Building building = new Building();
        buildingRepository.save(building);
        personInHouseMichael.withBuilding(building);
        personInHouseKarl.withBuilding(building);
    }

    @Transactional
    public void initPersonInHouseAndRoomMany2OneBi() {
        Person personMichael = new Person();
        personMichael.setName("Michael");
        personRepository.save(personMichael);
        PersonInHouse personInHouseMichael = new PersonInHouse().withPerson(personMichael);
        personInHouseRepository.save(personInHouseMichael);
        Person personKarl = new Person();
        personKarl.setName("Karl");
        personRepository.save(personKarl);
        PersonInHouse personInHouseKarl = new PersonInHouse().withPerson(personKarl);
        personInHouseRepository.save(personInHouseKarl);
        Room hall = new Room("Flur");
        roomRepository.save(hall);
        personInHouseMichael.withRoom(hall);
        personInHouseKarl.withRoom(hall);
        hall.addPersonInHouse(personInHouseMichael);
        hall.addPersonInHouse(personInHouseKarl);
    }

    @Transactional
    public void deletePersonInHouseMany2OneBi() {
        PersonInHouse personInHouseMichael = personInHouseRepository.findById(9).get();
        Room hall = personInHouseMichael.getRoom();
        personInHouseMichael.leaveRoom(hall);                       
        hall.deletePersonInHouse(personInHouseMichael);             
        personInHouseRepository.delete(personInHouseMichael);       
        Room room = personInHouseMichael.getRoom();                 
        if (room != null) {                                       
            log.info("Michael ist immer noch da ! im Raum " + room.getId());
            room.getPersonsInHouse().forEach(e -> System.out.println("und der Raum kennt immer noch den " + e.getId()));
        }                                                         
    }


    @Transactional
    public void deletePersonInHouseAndRoomMany2OneBiV0() {
        PersonInHouse personInHouseMichael = personInHouseRepository.findById(2).get();
        Room hall = personInHouseMichael.getRoom();
        personInHouseMichael.leaveRoom(hall);
        hall.deletePersonInHouse(personInHouseMichael);
        personInHouseRepository.save(personInHouseMichael);
        roomRepository.save(hall);
    }

    @Transactional
    public void deletePersonInHouseMany2OneBiV1() {
        PersonInHouse personInHouseMichael = personInHouseRepository.findById(2).get();
        Room hall = personInHouseMichael.getRoom();
        personInHouseMichael.leaveRoom(hall);
        hall.deletePersonInHouse(personInHouseMichael);
        personInHouseRepository.delete(personInHouseMichael);
        Room room = personInHouseMichael.getRoom();
        if (room != null) {
        	log.info("Michael ist immer noch da ! im Raum " + room.getId());
            room.getPersonsInHouse().forEach(e -> System.out.println("und der Raum kennt immer noch den " + e.getId()));
        }
    }

    @Transactional
    public void initMichael() {

        Person personMichael = new Person();
        personMichael.setName("Michael");

        Address addressMichael = new Address("Zwickau");

        personRepository.save(personMichael);
        addressRepository.save(addressMichael);

        //Wohnung
        Building buildingMichael = new Building().withAddress(addressMichael);
        Room livingRoom = new Room("Wohnzimmer");
        Room hall = new Room("Flur");
        Room bedroom = new Room("Schlafzimmer");
        Room kitchen = new Room("Kueche");
        Room bathroom = new Room("Badezimmer");

        hall.addRoom(livingRoom).addRoom(bedroom).addRoom(kitchen).addRoom(bathroom);

        personMichael.addOwnedBuildings(buildingMichael);
        buildingMichael.addRoom(livingRoom);
        buildingMichael.addRoom(hall);
        buildingMichael.addRoom(bedroom);
        buildingMichael.addRoom(bathroom);
        buildingMichael.addRoom(kitchen);


        buildingRepository.save(buildingMichael);

        roomRepository.save(livingRoom);
        roomRepository.save(hall);
        roomRepository.save(bedroom);
        roomRepository.save(bathroom);
        roomRepository.save(kitchen);

        PersonInHouse personInHouse = new PersonInHouse().withPerson(personMichael);

        personInHouseRepository.save(personInHouse);

        personInHouse.withBuilding(buildingMichael);
        personInHouse.withRoom(hall);

    }

    @Transactional
    public void initKarl() {

        Person personKarl = new Person();
        personKarl.setName("Karl");

        Address addressKarl = new Address("Zwickau");

        personRepository.save(personKarl);
        addressRepository.save(addressKarl);

        //Wohnung
        Building buildingKarl = new Building().withAddress(addressKarl);
        Room livingRoom = new Room("Wohnzimmer");
        Room hall = new Room("Flur");
        Room bedroom = new Room("Schlafzimmer");
        Room kitchen = new Room("Kueche");
        Room bathroom = new Room("Badezimmer");

        hall.addRoom(livingRoom).addRoom(kitchen);
        livingRoom.addRoom(bedroom);
        bedroom.addRoom(bathroom);

        personKarl.addOwnedBuildings(buildingKarl);
        buildingKarl.addRoom(livingRoom);
        buildingKarl.addRoom(hall);
        buildingKarl.addRoom(bedroom);
        buildingKarl.addRoom(bathroom);
        buildingKarl.addRoom(kitchen);


        buildingRepository.save(buildingKarl);

        roomRepository.save(livingRoom);
        roomRepository.save(hall);
        roomRepository.save(bedroom);
        roomRepository.save(bathroom);
        roomRepository.save(kitchen);

        PersonInHouse personInHouse = new PersonInHouse().withPerson(personKarl);

        personInHouseRepository.save(personInHouse);

        personInHouse.withBuilding(buildingKarl);
        personInHouse.withRoom(livingRoom);

    }
}
