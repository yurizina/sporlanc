package cct.sporlanc.model;

public class AddItem {
	
	
	private int addItem_ID;
	private int quantity;
	private int bookingID;
	//foreigner key from Booking Class
	private int item_id;
	//foreigner key from Item Class
	
	////////////////////////////////
	private int student_id;
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	//variable only to java methods 

	public AddItem() {
		
	}
	
	public AddItem(int quantity, int booking_ID, int item_id) {
		
		this.quantity = quantity;
		this.bookingID = booking_ID;
		this.item_id = item_id;
	}

	public int getAddItem_ID() {
		return addItem_ID;
	}
	public void setAddItem_ID(int addItem_ID) {
		this.addItem_ID = addItem_ID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
}
