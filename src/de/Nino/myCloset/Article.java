package de.Nino.myCloset;

import java.util.Scanner;

public class Article {
	
	//Attributes
	private String attributes[] = new String[4];
	
	//Constructor
	public Article (String type, String color, String size, String brand) {
		attributes[0] = type;
		attributes[1] = color;
		attributes[2] = size;
		attributes[3] = brand;
	}
	
	//Methods
	
	// creates an article
	public static Article createArticle () {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("******************************************************");
		System.out.println("*          Ok - Was möchtest du hinzufügen?          *");
		System.out.println("*            z.B. Jacke / Hose / T-Shirt             *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String type = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*      Ok - Welche Farbe hat das Kleidungsstück?     *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String color = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*      Ok - Welche Größe hat das Kleidungsstück?     *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String size = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*   Ok - Von welcher Marke ist das Kleidungsstück?   *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String brand = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*   Ok - Dein Kleidungsstück wurde aufgehangen! :)   *");
		System.out.println("******************************************************");
		
		Article newArticle = new Article(type, color, size, brand);
		
		return newArticle;
	}
	
	// shows an article from the closet
	public void printArticle() {
		System.out.println("******************************************************");
		System.out.println("* Dieses Kleidungsstück ist ein " + this.attributes[0]);
		System.out.println("* Es hat die Farbe: " + this.attributes[1]);
		System.out.println("* Die Größe ist: " + this.attributes[2]);
		System.out.println("* Es ist von der Marke: " + this.attributes[3]);
		System.out.println("******************************************************");
	}

	//getters
	public String[] getAttributes() {
		return attributes;
	}

}
