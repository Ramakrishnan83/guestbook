package com.glavanize.guestbook.model;

public class GuestEntry {
	
	private String guestName;
	private String comment;
	
	public GuestEntry() {
		
	}
	
	public GuestEntry(String guestName, String comment) {
		this.guestName = guestName;
		this.comment = comment;
	}
	
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
