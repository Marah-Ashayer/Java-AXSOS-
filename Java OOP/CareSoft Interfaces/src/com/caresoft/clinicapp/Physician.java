package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Math;
public class Physician extends User implements HIPAACompliantUser {
       
    private ArrayList<String> patientNotes;
	//--------------------------------///--------------------------------//
    
    
    // TO DO: Constructor that takes an ID
    public Physician(Integer id){
    	super(id);
    }
    
    
    // TO DO: Implement HIPAACompliantUser!
    @Override
	public boolean assignPin(int pin) {
		if ((int)(Math.log10(pin)+1)!=4) {
			return false;
		}
		this.setPin(pin);
		return true;
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID){
		if(this.id== confirmedAuthID){
			return true;
		}
		return false;
	}
	
	//----------------------------------------------------------------------
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	//------------------- Getters and Setters for patientNotes ---------------//
    public ArrayList<String> getPatientNotes(){
        return this.patientNotes ;
    }
    public void setPatientNotes(ArrayList<String> patientNotes){
        this.patientNotes=patientNotes ;
    }
   // -----------------------------------------------------------------------//
}
