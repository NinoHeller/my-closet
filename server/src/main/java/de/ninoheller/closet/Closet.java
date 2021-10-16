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
				/*myArticles.stream()
						.filter(article -> article.getType().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getColor))
						.forEach(article -> System.out.println("******************************************************\n"
																+article
																+"\n******************************************************"));*/

				for (Article article : myArticles.stream()
						.filter(article -> article.getType().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getColor))
						.collect(Collectors.toList())) {
					System.out.println("******************************************************");
					System.out.println(article);
					System.out.println("******************************************************");
				}
			}break;
			case 2:{	//search by color
				for (Article article : myArticles.stream()
						.filter(article -> article.getColor().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.collect(Collectors.toList())) {
					System.out.println("******************************************************");
					System.out.println(article);
					System.out.println("******************************************************");
				}
			}break;
			case 3:{	//search by brand
				for (Article article : myArticles.stream()
						.filter(article -> article.getBrand().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.collect(Collectors.toList())) {
					System.out.println("******************************************************");
					System.out.println(article);
					System.out.println("******************************************************");
				}
			}break;
			case 4:{	//search by size
				for (Article article : myArticles.stream()
						.filter(article -> article.getSize().equalsIgnoreCase(parameter))
						.sorted(Comparator.comparing(Article::getType))
						.collect(Collectors.toList())) {
					System.out.println("******************************************************");
					System.out.println(article);
					System.out.println("******************************************************");
				}
			}break;

		}
		return true;
	}

	// shows all articles from the closet
	public boolean showAllArticles() {
		Logger.print("Hier sind alle deine Kleidungsstücke.");
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
