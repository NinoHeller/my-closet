package de.ninoheller.closet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Closet {
	// Attributes
	private List<Article> myArticles;

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

	// shows all articles from the closet
	public boolean showAllArticles() {
		System.out.println("******************************************************");
		System.out.println("*        Hier sind alle deine Kleidungsstücke        *");
		System.out.println("******************************************************");
		for (Article article : myArticles) {
			System.out.println(article);
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
	public List<Article> getMyArticles() {
		return myArticles;
	}

	public int getSizeOfMyArticles() {
		return myArticles.size();
	}

}
