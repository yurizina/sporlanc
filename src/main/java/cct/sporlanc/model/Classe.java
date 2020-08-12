package cct.sporlanc.model;

public class Classe {

	private int class_ID;
	private String period;
	private String days;
	private int capactity;
	private int price;
	private String type;
	private int sport_id;
	private int emp_id;
	private int ages_id;
	private String language;
	
	private String language2;
	private String sport;
	private String period2;
	private String type2;
	private int availability; 
	private int age; 
	//Testing 
	private int student_id;
	//This is a FK from Employee
	
	public Classe () {
		
	}
	
	public Classe(String period, String days, int capactity, int price, String type, int sport_id, int emp_id, int ages_id, String language) {
		
		this.period = period;
		this.days = days;
		this.capactity = capactity;
		this.price = price;
		this.type = type;
		this.sport_id = sport_id;
		this.emp_id = emp_id;
		this.ages_id = ages_id;
		this.language = language;
		
	}
	
	//Only Java variables 
	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}
	

	public void set_sport(String sport) {
		this.sport = sport;
	}
	public String getSport() {
		return sport;
	}
	

	public String getPeriod2() {
		return period2;
	}

	public void setPeriod2(String period2) {
		this.period2 = period2;
	}
	
	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//Variables from Java and attributes from Databases 
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public int getCapactity() {
		return capactity;
	}
	public void setCapactity(int capactity) {
		this.capactity = capactity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getAges_id() {
		return ages_id;
	}

	public void setAges_id(int ages_id) {
		this.ages_id = ages_id;
	}
	public int getSport_id() {
		return sport_id;
	}

	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
//Testing 

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
		
}
