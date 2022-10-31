package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    //-------------------------------------------------------------------------//
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id,String role){
    	super(id);
    	this.role=role;
    	this.securityIncidents =new ArrayList<String>();
    }
    // TO DO: Implement HIPAACompliantUser!-------------------------------------
    
    @Override
 	public boolean assignPin(int pin) {
 		if ((int)(Math.log10(pin)+1)<6) {
// 			this.authIncident();
 			return false;
 		}
 		this.setPin(pin);
 		return true;
 	}
    
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID){
		if(this.id!= confirmedAuthID){
			this.authIncident();
			return false;
		}
		return true;
	}
    // TO DO: Implement HIPAACompliantAdmin!--------------------------------------
	@Override
	public ArrayList<String> reportSecurityIncidents(){
		return this.securityIncidents; 
	}
    //--------------------------------------------------------------------------//
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
  //------------------- Getters and Setters for employeeID -----------------//
    public Integer getEmployeeID() {
    	return this.employeeID;
    }
    public void setEmployeeID(Integer employeeID) {
    	this.employeeID = employeeID;
    }
  //------------------- Getters and Setters for role ----------------------//
    public String getRole(){
        return this.role ;
    }
    public void setRole(String role){
        this.role=role ;
    }
  //------------------- Getters and Setters for securityIncidents ---------------//
    public ArrayList<String> getSecurityIncidents(){
        return this.securityIncidents ;
    }
    public void setSecurityIncidents(ArrayList<String> securityIncidents){
        this.securityIncidents=securityIncidents ;
    }
}
