package com.shihaichen.newsservices;

import java.util.Map;

public class Intent {
	private String name;
	private Map<String, Slot> slots;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Slot> getSlots() {
		return slots;
	}
	public void setSlots(Map<String, Slot> slots) {
		this.slots = slots;
	}
	
}
