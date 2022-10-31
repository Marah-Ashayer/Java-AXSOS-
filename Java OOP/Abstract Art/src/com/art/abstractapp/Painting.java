package com.art.abstractapp;

public class Painting extends Art {
	public String paintType;
	
	//--------------Constructor ----------------------------------------------
	
	public Painting(String title,String author, String description,String paintType){
		super(title,author,description);
		this.paintType= paintType;
	}
	
	//----------------------------------------------------------------------//
	
	public void viewArt() {
		System.out.println("Paint Title : " + this.getTitle() );
		System.out.println("Paint Author : " + this.getAuthor() );
		System.out.println("Paint Description : " + this.getDescription() );
		System.out.println("Paint Type : " + this.getPaintType() );
	}
	
	//------------------- Getters and Setters for paintType ---------------//
    public String getPaintType(){
        return this.paintType ;
    }
    public void setPaintType(String paintType){
        this.paintType=paintType ;
    }
   // -----------------------------------------------------------------------//

}
