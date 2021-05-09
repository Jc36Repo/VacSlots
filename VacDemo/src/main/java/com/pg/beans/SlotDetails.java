package com.pg.beans;

public class SlotDetails {
	
	private String name;
	private int slots;
	private String pincode;
	private String date;
	
	public SlotDetails() {
		
	}
	
	public SlotDetails(String name, int slots, String pincode, String date) {
		super();
		this.name = name;
		this.slots = slots;
		this.pincode = pincode;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
