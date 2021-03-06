package com.glavanize.guestbook.controller;

import com.glavanize.guestbook.service.BookService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glavanize.guestbook.model.GuestEntry;

@RestController
@RequestMapping("/api")
public class GuestbookController {
	BookService bookService;

	public GuestbookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping(value = "/guests")
	public void saveGuestEntry(@RequestBody GuestEntry entry) {
		bookService.saveGuestEntry(entry);
	}
	
	@GetMapping(value = "/guests", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuestEntry> getGuestEntries() {
		return bookService.getGuestEntries();
	}

}
