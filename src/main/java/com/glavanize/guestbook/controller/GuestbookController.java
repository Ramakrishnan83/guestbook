package com.glavanize.guestbook.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glavanize.guestbook.model.GuestEntry;

@RestController
@RequestMapping("/api")
public class GuestbookController {
	
	@PostMapping(value = "/guests")
	public void saveGuestEntry(GuestEntry entry) {
		
	}

}
