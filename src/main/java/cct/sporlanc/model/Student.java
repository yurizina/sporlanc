package cct.sporlanc.model;

public class Student {

	

	private int studentID;
	private String first_name;
	private String surname;
	private String gender;
	private String birth_date;
	private int userID;
	// this attribute is a foreign key! 
	
	private int currentAge; 
	//Only in JAVA
	public int getCurrentAge() {
		return currentAge;
	}

	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}
	//Only in JAVA

	public Student() {

	}

	public Student(int studentID, String first_name, String surname, String gender,
			int userID, String birth_date) {

		this.first_name = first_name;
		this.surname = surname;
		this.gender = gender;
		this.userID = userID;
		this.birth_date = birth_date;
		
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


}
