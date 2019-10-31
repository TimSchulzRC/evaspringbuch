package de.evaspringbuch.eva05smarthome;


import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import de.evaspringbuch.eva05smarthome.Eva05SmartHome;
import de.evaspringbuch.eva05smarthome.complete.domain.PersonInHouse;
import de.evaspringbuch.eva05smarthome.complete.domain.PersonInHouseRepository;
import de.evaspringbuch.eva05smarthome.complete.domain.Room;
import de.evaspringbuch.eva05smarthome.complete.domain.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Eva05SmartHome.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmartHomeTest {

    @Autowired PersonInHouseRepository personInHouseRepository;
    @Autowired RoomRepository roomRepository;

    @Transactional
    @Test
    public void test1() {
        PersonInHouse heinz = new PersonInHouse();
        Room kueche = new Room();
        kueche.addName("kueche");
        heinz.withRoom(kueche);
        kueche.addPersonInHouse(heinz);
        roomRepository.save(kueche);
        personInHouseRepository.save(heinz);
        
        assertThat(kueche.getName()).isEqualTo("kueche");
    }

    @Transactional
    // with transaction no errors
    // without transaction error unsaved transient instance exception
    // change save sequence
    @Test
    public void test2() {
        PersonInHouse heinz = new PersonInHouse();
        Room kueche = new Room();
        kueche.addName("kueche");
        heinz.withRoom(kueche);
        kueche.addPersonInHouse(heinz);

        personInHouseRepository.save(heinz);
        roomRepository.save(kueche);
//        personInHouseRepository.save(heinz);
        
        assertThat(kueche.getName()).isEqualTo("kueche");
        assertThat(kueche.getPersonsInHouse().get(0)).isEqualTo(heinz);
        assertThat(heinz.getRoom()).isEqualTo(kueche);

    }
////
    @Transactional
    @Test
    // with transaction no errors
    // without transaction error lazy initialize exception
    public void test3() {
        PersonInHouse heinz = new PersonInHouse();

        Room kueche = new Room();
        kueche.addName("kueche");

        heinz.withRoom(kueche);
        kueche.addPersonInHouse(heinz);

//        personInHouseRepository.save(heinz);
        roomRepository.save(kueche);
        personInHouseRepository.save(heinz);

        Room kuecheFromDB = roomRepository.findById(kueche.getId()).get();
        PersonInHouse heinzFromStore = personInHouseRepository.findById(heinz.getId()).get();
        kueche.addName("wohnzimmer");
        
        assertThat(kuecheFromDB.getPersonsInHouse().get(0)).isEqualTo(heinz);
        assertThat(heinzFromStore.getRoom()).isEqualTo(kuecheFromDB);
        assertThat(heinzFromStore.getRoom().getName()).isEqualTo(kueche.getName());


    }

}
