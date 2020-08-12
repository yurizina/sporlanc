package cct.sporlanc.model;

public class Eircode {
	
	private int eircode_ID;
	private String eircode;
	
	public Eircode() {
		
	}
	
	public Eircode(int eircode_ID, String eircode) {
		
		this.eircode_ID = eircode_ID;
		this.eircode = eircode; 
	}
	public int getEircode_ID() {
		return eircode_ID;
	}
	public void setEircode_ID(int eircode_ID) {
		this.eircode_ID = eircode_ID;
	}
	public String getEircode() {
		return eircode;
	}
	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
	
	

}
