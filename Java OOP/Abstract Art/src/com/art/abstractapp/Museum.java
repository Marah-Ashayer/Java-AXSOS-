package com.art.abstractapp;
import java.util.ArrayList;

public class Museum {
	
	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art> ();

		Painting p1 = new Painting("title-1" , "author-1" , "description-1" , "paintType-1");
		Painting p2 = new Painting("title-22" , "author-22" , "description-22" , "paintType-22");
		Painting p3 = new Painting("title-333" , "author-333" , "description-333" , "paintType-333");
		
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		
		p1.viewArt();
		p2.viewArt();
		p3.viewArt();
		
		Sculpture s1 =new Sculpture("title-444" , "author-444" , "description-4444" , "material-44");
		Sculpture s2 =new Sculpture("title-555" , "author-555" , "description-555" , "material-55");
		
		museum.add(s1);
		museum.add(s2); 
		
		s1.viewArt();
		s2.viewArt();
		
		for(Art i : museum ){
			System.out.println(i);
		}
	}

}
