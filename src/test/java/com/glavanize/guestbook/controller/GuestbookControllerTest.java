package com.glavanize.guestbook.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.glavanize.guestbook.model.GuestEntry;
import com.glavanize.guestbook.service.BookService;

@WebMvcTest
public class GuestbookControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BookService bookService;

    /*
     * Test to validate saving of guest and comments is successful
     */
    @Test
    public void test_saveGuestNameAndComments() throws Exception{

        doNothing().when(bookService).saveGuestEntry(Mockito.any(GuestEntry.class));


        mvc.perform(
        		post("/api/guests")
        		.content("{\"guestName\" : \"string\",\"comment\" : \"string\"}")
        		.contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

        verify(bookService, times(1)).saveGuestEntry(Mockito.any(GuestEntry.class));
    }
    
    @Test
    public void test_getGuestEntries_zeroEntries() throws Exception {
    	
    	when(bookService.getGuestEntries()).thenReturn(new ArrayList<>());
    	mvc.perform(
        		get("/api/guests"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(0));
    }
    
}
