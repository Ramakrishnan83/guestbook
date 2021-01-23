package com.glavanize.guestbook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.glavanize.guestbook.model.GuestEntry;
import com.glavanize.guestbook.service.BookService;
import com.glavanize.guestbook.service.StaticData;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestbookControllerIntTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	BookService service;
	
	@AfterEach
	void clear() {
		StaticData.nuke();
	}

	@Test
	public void test_saveGuestNameAndComments() throws Exception {

		mvc.perform(post("/api/guests").content("{\"guestName\" : \"string\",\"comment\" : \"string\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		mvc.perform(get("/api/guests")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(1))
				.andExpect(jsonPath("$.[0].guestName").value("string"));
	}

	@Test
	public void test_getGuestEntries_multipleEntries() throws Exception {
		service.saveGuestEntry(new GuestEntry("Test", "TestEntry for Guest"));
		service.saveGuestEntry(new GuestEntry("Superstar", "No Comment"));

		mvc.perform(get("/api/guests")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$.[0].guestName").value("Test"));
	}

}
