package de.evaspringbuch.eva02hellogibberV1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.evaspringbuch.eva02hellogibberV1.boundary.HelloController;

@SpringBootTest //(classes = Eva02HelloGibberV1.class)
public class ServiceTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void testSayHello() {
        assertThat(helloController.helloMessage("hello")).isEqualTo("hello");
//        assertThat(helloController.helloMessage("hello")).isEqualTo(" na sowas :: hello");
    }
}
