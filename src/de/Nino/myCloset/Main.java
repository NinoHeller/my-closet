package de.Nino.myCloset;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Closet myCloset = new Closet();
		Scanner scanner = new Scanner(System.in);
		int mainMenueSelection;
		int searchArticleSelection;
		int indexSelection;
		String searchParameter;

		do {
			MainMenue.showMainMenue();
			mainMenueSelection = scanner.nextInt();

			switch (mainMenueSelection) {
			case 1: {
				myCloset.addArticle(Article.createArticle());
			}
				break;
			case 2: {
				if (myCloset.getSizeOfMyArticles() == 0) {
					System.out.println("******************************************************");
					System.out.println("*         Du hast noch keine Kleidungsstücke         *");
					System.out.println("******************************************************");
				} else {
					SearchArticle.searchArticle();
					searchArticleSelection = scanner.nextInt();

					if (searchArticleSelection == 5) {
						myCloset.showAllArticles();
					} else if (searchArticleSelection > 5) {
						System.out.println("******************************************************");
						System.out.println("*           Diese Auswahl gibt es nicht!             *");
						System.out.println("******************************************************");

					} else {
						System.out.println("******************************************************");
						System.out.println("*            Wonach möchtest du suchen?              *");
						System.out.println("*                       ...                          *");
						System.out.println("******************************************************");
						searchParameter = scanner.next();
						myCloset.showArticle(searchArticleSelection, searchParameter);

					}

				}

			}
				break;
			case 3: {
				if (myCloset.getSizeOfMyArticles() == 0) {
					System.out.println("******************************************************");
					System.out.println("*         Du hast noch keine Kleidungsstücke         *");
					System.out.println("******************************************************");
				} else {
					myCloset.showAllArticles();
					System.out.println("******************************************************");
					System.out.println("* Bitte gib die Stelle ein die gelöscht werden soll. *");
					System.out.println("*                        ...                         *");
					System.out.println("******************************************************");
					indexSelection = scanner.nextInt();

					if (indexSelection > myCloset.getSizeOfMyArticles()) {
						System.out.println("******************************************************");
						System.out.println("*            Diese Stelle gibt es nicht!             *");
						System.out.println("******************************************************");
					} else {
						myCloset.removeArticle(indexSelection);
					}
				}

			}
				break;
			case 4: {
				System.out.println("******************************************************");
				System.out.println("*              Ok - Auf Wiedersehen! :)              *");
				System.out.println("******************************************************");
			}
				break;
			default: {
				System.out.println("******************************************************");
				System.out.println("*           Diese Auswahl gibt es nicht!             *");
				System.out.println("******************************************************");
			}
				break;
			}

		} while (mainMenueSelection != 4);

		scanner.close();

	}

}
