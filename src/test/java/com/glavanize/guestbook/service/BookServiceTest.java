package com.glavanize.guestbook.service;

import com.glavanize.guestbook.model.GuestEntry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BookServiceTest {
    @Test
    public void TestSaveGuestEntry() {
        BookService bookService = new BookService();
        List<GuestEntry> actualGuestList = new ArrayList<>();
        GuestEntry testEntry = new GuestEntry("Test", "TestEntry for Guest");
        bookService.saveGuestEntry(testEntry);
        actualGuestList = bookService.getGuestEntries();
        assertEquals(actualGuestList.get(0).getGuestName(), "Test");

    }

    @Test
    public void TestSaveGuestEntryMultiple() {
        BookService bookService = new BookService();
        List<GuestEntry> actualGuestList = new ArrayList<>();
        GuestEntry testEntry = new GuestEntry("Test", "TestEntry for Guest");
        bookService.saveGuestEntry(testEntry);
        GuestEntry testEntry1 = new GuestEntry("Test1", "TestEntry for Guest1");
        bookService.saveGuestEntry(testEntry1);
        actualGuestList = bookService.getGuestEntries();
        assertEquals(actualGuestList.get(1).getGuestName(), "Test1");

    }
}