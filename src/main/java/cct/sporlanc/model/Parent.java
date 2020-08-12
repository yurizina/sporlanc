package cct.sporlanc.model;

public class Parent {

	private int user_ID;
	private String first_name; 
	private String surname;
	private String address; 
	private int phone;
	private int eircodeID; 
	//this is a FK from Eircode Class; 
	private String username;
	private String email;
	private String password;
	
	public Parent() {
		
	}
	
	public Parent(int user_ID, String surname, String email, String password, String first_name, String username, String address, int phone, int eircodeID) {

		this.email = email;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.eircodeID = eircodeID;
	}
	
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getEircodeID() {
		return eircodeID;
	}
	public void setEircodeID(int eircodeID) {
		this.eircodeID = eircodeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
