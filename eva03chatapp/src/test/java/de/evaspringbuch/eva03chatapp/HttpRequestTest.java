package de.evaspringbuch.eva03chatapp;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();        
    }

    @Test
    public void getPosts() throws Exception {
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("from", "elisa")
                .param("to", "marga")
                )
                .andExpect(status().isOk());
    }

    @Test
    public void getPostsInMoreDetails() throws Exception {
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("from", "elisa")
                .param("to", "marga")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("posting"))                   
                .andExpect(model().attribute("listAllPosts", hasSize(7)))      
                .andExpect(model().attribute("toUser", "marga"))        
                .andDo(print());
    }

    @Test
    public void newPost() throws Exception {
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("from", "elisa")
                .param("to", "marga")
                .param("pcontent", "test")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("posts?from=elisa&to=marga"));
    }
}