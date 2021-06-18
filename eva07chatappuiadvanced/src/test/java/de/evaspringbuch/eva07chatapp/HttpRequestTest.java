package de.evaspringbuch.eva07chatapp;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.evaspringbuch.eva07chatapp.chat.domain.Chat;
import de.evaspringbuch.eva07chatapp.security.domain.CurrentUser;
import de.evaspringbuch.eva07chatapp.security.domain.UserRepository;

@SpringBootTest 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HttpRequestTest {
	
	@Autowired private WebApplicationContext wac;
	private MockMvc mockMvc;
    @Autowired private UserRepository userRepository;
    @Autowired CurrentUser currentUser;
    @Autowired MockHttpSession mocksession;
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
        		.webAppContextSetup(wac)
                .build();
        		currentUser.setUser(userRepository.findOneByEmail("el@a").get());
    }

    @Test
    @Order(1)
    public void testNewchat() throws Exception {
    	System.out.println("first");
    	mockMvc.perform(
			 	get("/newchat")
			 	.session(mocksession)
			 	.param("nid", "marga")
           
        ).andExpect(status().isOk())
    	 .andExpect(view().name("newchat"))
    	 .andExpect(model().attribute("listAllChats", hasSize(1)))
    	 .andExpect(model().attribute("listAllChats", Matchers.hasItems(Matchers.<Chat> hasProperty("chatWith", equalToIgnoringCase("marga")))))
    	;
    }
    
    @Test
    @Order(2)
    public void testPostToChat() throws Exception {
    	System.out.println("second");
        mockMvc.perform(
        			post("/add")
	        		.session(mocksession)
	                .param("to", "marga")
	                .param("pcontent", "test")
        )
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("posts?to=marga"))
        ;
    }
}

