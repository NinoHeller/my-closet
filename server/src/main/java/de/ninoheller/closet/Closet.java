package de.ninoheller.closet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class Closet {
	// Attributes
	private ArrayList<Article> myArticles;

	// Constructor
	public Closet() {
		myArticles = new ArrayList<>();
	}

	// methods

	// adds an article to the closet
	public boolean addArticle(Article newArticle) {
		myArticles.add(newArticle);
		return true;
	}

	// search for an article from the closet
	public boolean showArticle(int selection, String searchParameter) {
		int counter = 0;
		for (Article article : myArticles) {
			if (article.getAttributes()[selection - 1].equals(searchParameter)) {
				article.printArticle();
				counter += 1;
			}

		}
		if (counter == 0) {
			System.out.println("******************************************************");
			System.out.println("*     Davon hast du noch keine Kleidungsst�cke!      *");
			System.out.println("******************************************************");
		}
		return true;
	}

	// shows all articles from the closet
	public boolean showAllArticles() {
		System.out.println("******************************************************");
		System.out.println("*        Hier sind alle deine Kleidungsst�cke        *");
		System.out.println("******************************************************");
		for (Article article : myArticles) {
			article.printArticle();
			System.out.println(
					"Es h�ngt an " + (myArticles.indexOf(article) + 1) + ". Stelle in deinem Kleiderschrank.\n\n");
		}
		return true;
	}

	// removes an article from the closet
	public boolean removeArticle(int selection) {
		myArticles.remove(selection - 1);
		System.out.println("******************************************************");
		System.out.println("*        Das Kleidungsst�ck wurde entfernt!          *");
		System.out.println("******************************************************");

		return true;
	}

	// getters
	public ArrayList<Article> getMyArticles() {
		return myArticles;
	}

	public int getSizeOfMyArticles() {
		return myArticles.size();
	}

}
