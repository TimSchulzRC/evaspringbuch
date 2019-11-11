package de.evaspringbuch.eva06smarthomeadvanced;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.evaspringbuch.eva06smarthomeadvanced.Eva06SmartHomeAdvanced;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Building;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.BuildingRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Person;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonInHouseRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.PersonRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.Room;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domain.RoomRepository;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.domainInheritance.Gender;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = Eva06SmartHomeAdvanced.class)
public class SmartHomeAdvancedTest {

    @Autowired PersonInHouseRepository personInHouseRepository;
    @Autowired RoomRepository roomRepository;
    @Autowired PersonRepository personRepository;
    @Autowired BuildingRepository buildingRepository;
    
//    @Transactional 
    @Test
    public void testNewBuilding1() {

        Building building = 
        		new Building();
        building = buildingRepository.save(building);
//        building.addOwner(new Person());        
//        buildingRepository.delete(building);
    }

    @Transactional 
    @Test
    public void testNewBuilding2() {

        Building building = buildingRepository.findById(1).get();
        building.addOwner(new Person());        
        buildingRepository.save(building);
    }

    @Transactional 
//    @Test
    public void testNameStartingWithOne() {
        assertThat(personRepository.findByName("Laura").getName()).isEqualTo("Laura");
    }

//    @Transactional 
//    @Test
//    public void testNameStartingWithList() {
//    	Person personLaura = new Person();
//    	personLaura.setName("Laura-Ann");
//    	personRepository.save(personLaura);
//        assertThat(personRepository.findByNameStartingWith("Laura").size()).isEqualTo(2);
//    }
    
    @Transactional 
    @Test
    public void testLastnameAndGender() {
    	Person personToniF = new Person();
    	personToniF.setName("Toni");
    	personToniF.setGender(Gender.female);
        personRepository.save(personToniF);
        assertThat(personRepository.findByNameAndGender("Toni", Gender.female).getId()).isEqualTo(3);
//        assertThat(personRepository.findByNameAndGender("Toni", Gender.male).getId()).isEqualTo(3);
    }
    
    @Transactional
    @Test
    public void testQueries() {
        List<Room> r = buildingRepository.findRoomInBuilding("Schlafzimmer");       
        assertThat(r).extracting("name", String.class).contains("Schlafzimmer");

        Building b = buildingRepository.searchTheBuildingAtAddress("Berlin");
        assertThat(b.getAddress().getCity()).isEqualTo("Berlin");
    }

}
