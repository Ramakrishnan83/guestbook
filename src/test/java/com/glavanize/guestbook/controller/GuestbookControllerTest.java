package com.glavanize.guestbook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class GuestbookControllerTest {

    @Autowired
    MockMvc mvc;
    

    /*
     * Test to validate saving of guest and comments is successful
     */
    @Test
    public void test_saveGuestNameAndComments() throws Exception{
        mvc.perform(
        		post("/api/guests")
        		.content("{\"guestName\" : \"string\",\"comment\" : \"string\"}")
        		.contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }
    
    
}
