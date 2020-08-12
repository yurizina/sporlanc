package cct.sporlanc.model;

public class Item {
	//This class simply maps a row in the table contact 
	//to a plain old Java object (POJO) - Item.
	
	private int item_id;
	private String name;
	private int price;
	private String availability;
	private String type;
	
	public Item () {
		
	}
	
	public Item (String name, int price, String availability, String type) {
		this.name = name;
		this.price = price;
		this.availability = availability;
		this.type = type;
	}
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	} 
}
