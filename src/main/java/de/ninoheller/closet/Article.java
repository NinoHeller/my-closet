package de.ninoheller.closet;

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
		System.out.println("*          Ok - Was m�chtest du hinzuf�gen?          *");
		System.out.println("*            z.B. Jacke / Hose / T-Shirt             *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String type = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*      Ok - Welche Farbe hat das Kleidungsst�ck?     *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String color = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*      Ok - Welche Gr��e hat das Kleidungsst�ck?     *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String size = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*   Ok - Von welcher Marke ist das Kleidungsst�ck?   *");
		System.out.println("*                        ...                         *");
		System.out.println("******************************************************");
		String brand = scanner.next();
		System.out.println("******************************************************");
		System.out.println("*   Ok - Dein Kleidungsst�ck wurde aufgehangen! :)   *");
		System.out.println("******************************************************");

		Article newArticle = new Article(type, color, size, brand);

		return newArticle;
	}

	// shows an article from the closet
	public void printArticle() {
		System.out.println("******************************************************");
		System.out.println("* Dieses Kleidungsst�ck ist ein " + this.attributes[0]);
		System.out.println("* Es hat die Farbe: " + this.attributes[1]);
		System.out.println("* Die Gr��e ist: " + this.attributes[2]);
		System.out.println("* Es ist von der Marke: " + this.attributes[3]);
		System.out.println("******************************************************");
	}

	//getters
	public String[] getAttributes() {
		return attributes;
	}

}
