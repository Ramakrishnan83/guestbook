package com.glavanize.guestbook.controller;

import com.glavanize.guestbook.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void saveGuestEntry(GuestEntry entry) {
		bookService.saveGuestEntry(entry);
	}

}
