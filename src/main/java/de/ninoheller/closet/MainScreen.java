package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class MainScreen {

    private final Closet closet;

    @Autowired
    public MainScreen(Closet closet) {
        this.closet = closet;
    }

    @PostConstruct
    public void show() {
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
                    closet.addArticle(Article.createArticle());
                }
                break;
                case 2: {
                    if (closet.getSizeOfMyArticles() == 0) {
                        System.out.println("******************************************************");
                        System.out.println("*         Du hast noch keine Kleidungsst�cke         *");
                        System.out.println("******************************************************");
                    } else {
                        SearchArticle.searchArticle();
                        searchArticleSelection = scanner.nextInt();

                        if (searchArticleSelection == 5) {
                            closet.showAllArticles();
                        } else if (searchArticleSelection > 5) {
                            System.out.println("******************************************************");
                            System.out.println("*           Diese Auswahl gibt es nicht!             *");
                            System.out.println("******************************************************");

                        } else {
                            System.out.println("******************************************************");
                            System.out.println("*            Wonach m�chtest du suchen?              *");
                            System.out.println("*                       ...                          *");
                            System.out.println("******************************************************");
                            searchParameter = scanner.next();
                            closet.showArticle(searchArticleSelection, searchParameter);

                        }

                    }

                }
                break;
                case 3: {
                    if (closet.getSizeOfMyArticles() == 0) {
                        System.out.println("******************************************************");
                        System.out.println("*         Du hast noch keine Kleidungsst�cke         *");
                        System.out.println("******************************************************");
                    } else {
                        closet.showAllArticles();
                        System.out.println("******************************************************");
                        System.out.println("* Bitte gib die Stelle ein die gel�scht werden soll. *");
                        System.out.println("*                        ...                         *");
                        System.out.println("******************************************************");
                        indexSelection = scanner.nextInt();

                        if (indexSelection > closet.getSizeOfMyArticles()) {
                            System.out.println("******************************************************");
                            System.out.println("*            Diese Stelle gibt es nicht!             *");
                            System.out.println("******************************************************");
                        } else {
                            closet.removeArticle(indexSelection);
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

        } while(mainMenueSelection !=4);

        scanner.close();

    }

}
