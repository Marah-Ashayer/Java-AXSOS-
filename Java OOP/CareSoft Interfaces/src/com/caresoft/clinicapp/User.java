package com.caresoft.clinicapp;

	public class User {
	    protected Integer id;
	    protected int pin;
	    
		// ------------------- Constructor for User -------------------//
	    public User(Integer id){
	    	super();
	    	this.id=id;
	    	
	    }
	   //------------------- Getters and Setters for id   -------------------//
	    public Integer getId(){
	        return this.id ;
	    }
	    public void setId(Integer id){
	        this.id=id ;
	    }
	   // ----------------- Getters and Setters for pin   -------------------//

	    public int getPin() {
	    	return this.pin;
	    }
	    public void setPin(int pin) {
	    	this.pin=pin;
	    }
	    

	}

