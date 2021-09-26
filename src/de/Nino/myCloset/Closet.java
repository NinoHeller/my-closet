package de.Nino.myCloset;

import java.util.ArrayList;
import java.util.Scanner;

public class Closet {
	// Attributes
	private ArrayList<Article> myArticles;
	private Scanner scanner = new Scanner(System.in);

	// Constructor
	public Closet() {
		myArticles = new ArrayList<Article>();
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
			System.out.println("*     Davon hast du noch keine Kleidungsstücke!      *");
			System.out.println("******************************************************");
		}
		return true;
	}

	// shows all articles from the closet
	public boolean showAllArticles() {
		System.out.println("******************************************************");
		System.out.println("*        Hier sind alle deine Kleidungsstücke        *");
		System.out.println("******************************************************");
		for (Article article : myArticles) {
			article.printArticle();
			System.out.println(
					"Es hängt an " + (myArticles.indexOf(article) + 1) + ". Stelle in deinem Kleiderschrank.\n\n");
		}
		return true;
	}

	// removes an article from the closet
	public boolean removeArticle(int selection) {
		myArticles.remove(selection - 1);
		System.out.println("******************************************************");
		System.out.println("*        Das Kleidungsstück wurde entfernt!          *");
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
