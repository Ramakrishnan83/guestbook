package com.glavanize.guestbook.service;

import java.util.ArrayList;
import java.util.List;

import com.glavanize.guestbook.model.GuestEntry;

public class StaticData {
	
	private static final List<GuestEntry> entries = new ArrayList<>();

	public static List<GuestEntry> getEntries() {
		return entries;
	}
	
	public static void addEntry(GuestEntry entry) {
		entries.add(entry);
	}
	
	public static void nuke() {
		entries.clear();
	}
	

}
