package de.ninoheller.closet;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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
			case 1:{	//search by type
				myArticles.stream()
						.filter(article -> article.getType().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getColor))
						.forEach(article -> System.out.println(article));
			}break;
			case 2:{	//search by color
				myArticles.stream()
						.filter(article -> article.getColor().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.forEach(article -> System.out.println(article));
			}break;
			case 3:{	//search by brand
				myArticles.stream()
						.filter(article -> article.getBrand().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.forEach(article -> System.out.println(article));
			}break;
			case 4:{	//search by size
				myArticles.stream()
						.filter(article -> article.getSize().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.forEach(article -> System.out.println(article));
			}break;

		}
		return true;
	}

	// shows all articles from the closet
	public boolean showAllArticles() {
		Logger.print("Hier sind alle deine Kleidungsstücke.");
		myArticles.stream()
				.sorted(Comparator.comparing(Article::getType))
				.forEach(article -> System.out.println(article));
		return true;
	}

	// removes an article from the closet
	public boolean removeArticle(int selection) {
		//myArticles.remove(selection - 1);
		Logger.print("Das Kleidungsstück wurde entfernt.");
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
