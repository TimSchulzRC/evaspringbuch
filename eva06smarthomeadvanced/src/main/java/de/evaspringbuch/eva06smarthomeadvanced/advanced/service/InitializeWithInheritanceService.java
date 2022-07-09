package de.evaspringbuch.eva06smarthomeadvanced.advanced.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Address;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.AddressRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonInHouseRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.RoomRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.BuildingWithInheritanceRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.OfficeBuilding;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.OfficeBuildingRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.PrivateHouse;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.PrivateHouseRepository;

@Service
public class InitializeWithInheritanceService {

	private static final Logger log = LoggerFactory.getLogger(InitializeWithInheritanceService.class);
	
    @Autowired
    private PersonInHouseRepository personInHouseRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BuildingWithInheritanceRepository buildingRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private OfficeBuildingRepository officeBuildingRepository;
    @Autowired
    private PrivateHouseRepository privateHouseRepository;


    @Transactional
    public void initInheritanceBuilding() {
        Address addressBerlin = new Address("Berlin");
        Address addressMuenchen = new Address("Muenchen");
        Address addressHamburg = new Address("Hamburg");

        addressRepository.save(addressBerlin);
        addressRepository.save(addressHamburg);
        addressRepository.save(addressMuenchen);

        Building building = new Building().withAddress(addressBerlin);
        OfficeBuilding officeBuilding = ((OfficeBuilding) new OfficeBuilding().withAddress(addressHamburg)).withSector("IT");
        PrivateHouse privateHouse = ((PrivateHouse) new PrivateHouse().withAddress(addressMuenchen)).withChildren(5);

        buildingRepository.save(building);
        officeBuildingRepository.save(officeBuilding);
        privateHouseRepository.save(privateHouse);

    }
    
//    @Transactional
//    public void findBuildingInCity() {
//        Address addressBerlin = new Address("Berlin");
//        Address addressMuenchen = new Address("Muenchen");
//        Address addressHamburg = new Address("Hamburg");
//
//        addressRepository.save(addressBerlin);
//        addressRepository.save(addressHamburg);
//        addressRepository.save(addressMuenchen);
//
//        Building building = new Building().withAddress(addressBerlin);
//        OfficeBuilding officeBuilding = ((OfficeBuilding) new OfficeBuilding().withAddress(addressHamburg)).withSector("IT");
//        PrivateHouse privateHouse = ((PrivateHouse) new PrivateHouse().withAddress(addressMuenchen)).withChildren(5);
//
//        buildingRepository.save(building);
//        officeBuildingRepository.save(officeBuilding);
//        privateHouseRepository.save(privateHouse);
//        
//        log.info(buildingRepository.searchTheBuildingAtAddress("Berlin").toString());
//
//    }
//
//    @Transactional
//    public void initEmbeddableBuilding() {
//        Address addressBerlin = new Address("Berlin");
//        Address addressHamburg = new Address("Hamburg");
//        Address addressMuenchen = new Address("Muenchen");
//
//        addressBerlin.setAdvancedAddress("10405", "Christinenstraße");
//        addressHamburg.setAdvancedAddress("21035", "Anitastraße");
//        addressMuenchen.setAdvancedAddress("80801", "Agnesstraße");
//
//        addressRepository.save(addressBerlin);
//        addressRepository.save(addressHamburg);
//        addressRepository.save(addressMuenchen);
//
//        Building buildingBerlin = new Building().withAddress(addressBerlin);
//        Building buildingHamburg = new Building().withAddress(addressHamburg);
//        Building buildingMuenchen = new Building().withAddress(addressMuenchen);
//
//        buildingRepository.save(buildingBerlin);
//        buildingRepository.save(buildingHamburg);
//        buildingRepository.save(buildingMuenchen);
//
//    }
//
//    @Transactional
//    public void initEnumeratedBuilding() {
//        Person personMichael = new Person();
//        personMichael.setName("Michael");
//        personMichael.setGender(Gender.male);
//        Person personAnna = new Person();
//        personAnna.setName("Anna");
//        personAnna.setGender(Gender.female);
//        Person personHannes = new Person();
//        personHannes.setName("Hannes");
//        personHannes.setGender(Gender.male);
//
//        personRepository.saveAll(Arrays.asList(personMichael, personAnna, personHannes));
//
//        Building buildingBerlin = new Building();
//        Building buildingMuenchen = new Building();
//        Building buildingBern = new Building();
//
//        buildingRepository.saveAll(Arrays.asList(buildingBerlin, buildingMuenchen, buildingBern));
//
//        personMichael.addOwnedBuildings(buildingBerlin);
//        personAnna.addOwnedBuildings(buildingMuenchen);
//        personHannes.addOwnedBuildings(buildingBern);
//
//    }
//
//
////    @Transactional
////    public void initEnumeratedBuilding() {
////        Person personMichael = new Person();
////        personMichael.setName("Michael");
////        personMichael.setGender(Gender.male);
////        personRepository.save(personMichael);
////
////        Building buildingBerlin = new Building();
////        buildingRepository.save(buildingBerlin);
////
////        personMichael.addOwnedBuildings(buildingBerlin);
////
////        Person personAnna = new Person();
////        personAnna.setName("Anna");
////        personAnna.setGender(Gender.female);
////        personRepository.save(personAnna);
////
////        Building buildingMuenchen = new Building();
////        buildingRepository.save(buildingMuenchen);
////
////        personAnna.addOwnedBuildings(buildingMuenchen);
////
////        Person personHannes = new Person();
////        personHannes.setName("Hannes");
////        personHannes.setGender(Gender.male);
////        personRepository.save(personHannes);
////
////        Building buildingBern = new Building();
////        buildingRepository.save(buildingBern);
////
////        personHannes.addOwnedBuildings(buildingBern);
////
////    }
//

}
