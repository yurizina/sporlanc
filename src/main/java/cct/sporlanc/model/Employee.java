package cct.sporlanc.model;

public class Employee {
	
	
	private int emp_id;
	private String username;
	private String gender;
	private String birth_date;
	private String staff_role;
	private String hire_date;
	private String email; 
	private String password;
	
	private String first_name; 
	private String surname;
	private String address; 
	private int phone;
	private int eircodeID; 
	//this is a FK from Eircode Class; 
	public Employee() {
		
	}
	
	public Employee(int emp_id, String username, String gender, String birth_date, String staff_role, String hire_date,
			String email, String password, String first_name, String surname, String address, int phone,
			int eircodeID) {
		super();
		this.emp_id = emp_id;
		this.username = username;
		this.gender = gender;
		this.birth_date = birth_date;
		this.staff_role = staff_role;
		this.hire_date = hire_date;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.eircodeID = eircodeID;
	}
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getStaff_role() {
		return staff_role;
	}
	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
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
	
}
