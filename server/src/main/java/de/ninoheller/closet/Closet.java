package de.ninoheller.closet;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Closet {
	// Attributes
	private Set<Article> myArticles;

	// Constructor
	public Closet() {
		myArticles = new LinkedHashSet<>();
	}

	// methods

	// adds an article to the closet
	public boolean addArticle(Article newArticle) {
		myArticles.add(newArticle);
		return true;
	}

	// search for an article from the closet
	public boolean searchArticle(int selection, String parameter){
		switch (selection){
			case 1:{
				for (Article article : myArticles) {
					if (article.getType().equalsIgnoreCase(parameter)) {
						System.out.println("******************************************************");
						System.out.println(article);
						System.out.println("******************************************************");
					}
				}
			}break;
			case 2:{
				for (Article article : myArticles) {
					if (article.getColor().equalsIgnoreCase(parameter)) {
						System.out.println("******************************************************");
						System.out.println(article);
						System.out.println("******************************************************");
					}
				}
			}break;
			case 3:{
				for (Article article : myArticles) {
					if (article.getBrand().equalsIgnoreCase(parameter)) {
						System.out.println("******************************************************");
						System.out.println(article);
						System.out.println("******************************************************");
					}
				}
			}break;
			case 4:{
				for (Article article : myArticles) {
					if (article.getSize().equalsIgnoreCase(parameter)) {
						System.out.println("******************************************************");
						System.out.println(article);
						System.out.println("******************************************************");
					}
				}
			}break;

		}
		return true;
	}

	// shows all articles from the closet
	public boolean showAllArticles() {
		System.out.println("******************************************************");
		System.out.println("*        Hier sind alle deine Kleidungsstücke        *");
		System.out.println("******************************************************");
		for (Article article : myArticles) {
			System.out.println("******************************************************");
			System.out.println(article);
			System.out.println("******************************************************");
		}
		return true;
	}

	// removes an article from the closet
	public boolean removeArticle(int selection) {
		//myArticles.remove(selection - 1);
		System.out.println("******************************************************");
		System.out.println("*        Das Kleidungsstück wurde entfernt!          *");
		System.out.println("******************************************************");

		return true;
	}

	// getters
	public Set<Article> getMyArticles() {
		return myArticles;
	}

	public int getSizeOfMyArticles() {
		return myArticles.size();
	}

}
