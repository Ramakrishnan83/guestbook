package com.glavanize.guestbook.service;

import com.glavanize.guestbook.model.GuestEntry;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
@Scope("singleton")
public class BookService {    

    public void saveGuestEntry(GuestEntry guestEntry) {
        StaticData.addEntry(guestEntry);
    }

    public List<GuestEntry> getGuestEntries() {    	
        return StaticData.getEntries();
    }
}
