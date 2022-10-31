package com.art.abstractapp;
import java.util.ArrayList;

public abstract class Art {
	public String title;
	public String author;
	public String description;
	
	public Art(String title ,String author ,String description){
		super();
		this.title = title;
		this.author=author;
		this.description=description;	
	}
	public abstract void viewArt();
	
	//------------------- Getters and Setters for title ---------------//
    public String getTitle(){
        return this.title ;
    }
    public void setTitle(String title){
        this.title=title ;
    }
   // -----------------------------------------------------------------------//
    
	//------------------- Getters and Setters for author ---------------//
    public String getAuthor(){
        return this.author ;
    }
    public void setAuthor(String author){
        this.author=author ;
    }
   // -----------------------------------------------------------------------//
    
	//------------------- Getters and Setters for author ---------------//
    public String getDescription(){
        return this.description ;
    }
    public void setDescription(String description){
        this.description=description ;
    }
   // -----------------------------------------------------------------------//
}
