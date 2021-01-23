package com.glavanize.guestbook.service;

import com.glavanize.guestbook.model.GuestEntry;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("singleton")
public class BookService {
    List<GuestEntry> guestEntries;

    public BookService() {
        this.guestEntries = new ArrayList<>();
    }

    public void saveGuestEntry(GuestEntry guestEntry) {
        guestEntries.add(guestEntry);
    }

    public List<GuestEntry> getGuestEntries() {
        return guestEntries;
    }
}
