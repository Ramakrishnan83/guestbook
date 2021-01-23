package com.glavanize.guestbook.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.glavanize.guestbook.model.GuestEntry;
import com.glavanize.guestbook.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
    
    
}
