package com.almita.models;

public class Room {
	
	private int customerID;
	
	private String description;
	
	private double price;
	private int roomID;
	
	
	public Room() {
		this.customerID=-1;
		this.description="none";
		this.roomID=-1;
		this.price=0;
	}
	
	public Room(int customerID, String description, double price, int roomID) {
		super();
		this.customerID = customerID;
		this.description = description;
		this.price = price;
		this.roomID = roomID;
	}
	
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
