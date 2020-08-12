package cct.sporlanc.model;

public class Booking {
	
	
	private int booking_ID;
	private int studentID;
	private String subscription;
	private String from_date;
	private int class_ID;
	
	
	public Booking() {
		
	}
	public Booking(int studentID, String subscription, String from_date,
			int class_ID) {
		this.studentID = studentID;
		this.subscription = subscription;
		this.from_date = from_date;
		this.class_ID = class_ID;
		
	}

	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getBooking_ID() {
		return booking_ID;
	}
	public void setBooking_ID(int booking_ID) {
		this.booking_ID = booking_ID;
	}
	
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	

}
