package com.glavanize.guestbook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glavanize.guestbook.model.GuestEntry;

@RestController
@RequestMapping("/api")
public class GuestbookController {
	
	@PostMapping(value = "/guests", produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveGuestEntry(GuestEntry entry) {
		
	}

}
