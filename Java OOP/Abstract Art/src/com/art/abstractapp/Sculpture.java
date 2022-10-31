package com.art.abstractapp;

public class Sculpture extends Art {
	public String material ;
	
	// --------------Constructor ---------------------------------------//
	public Sculpture(String title,String author, String description,String material){
		super(title,author,description);
		this.material= material;
	}  
	
	// -----------------------------------------------------------------//
	
	public void viewArt() {
		System.out.println("Paint Title : " + this.getTitle() );
		System.out.println("Paint Author : " + this.getAuthor() );
		System.out.println("Paint Description : " + this.getDescription() );
		System.out.println("Paint Type : " + this.getMaterial() );
	}
	
	//-----------------------------------------------------------------// 
	
	//------------------- Getters and Setters for paintType ---------------//
    public String getMaterial(){
        return this.material ;
    }
    public void setMaterial(String material){
        this.material=material ;
    }
   // -----------------------------------------------------------------------//
}
