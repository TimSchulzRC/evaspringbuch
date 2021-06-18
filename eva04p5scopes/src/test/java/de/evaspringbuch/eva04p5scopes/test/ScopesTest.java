package de.evaspringbuch.eva04p5scopes.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScopesTest {

	 @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Autowired
	    private WebApplicationContext wac;

	    private MockMvc mockMvc;

	    @BeforeEach
	    public void setup() {
	        mockMvc = MockMvcBuilders
	                .webAppContextSetup(wac)
	                .build();
	    }


	    @Test
	    @Order(1)
	    public void pressHit1Button() throws Exception {
	        mockMvc.perform(get("/hit")
	                )
	                .andExpect(status().isOk());
	    }
	    
	    @Test
	    @Order(2)
	    public void pressHit2Button() throws Exception {
	    	mockMvc.perform(get("/hit2")
	                )
	                .andExpect(status().isOk());
	    }

}
