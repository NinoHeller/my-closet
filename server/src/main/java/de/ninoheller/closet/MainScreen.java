package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MainScreen implements ApplicationListener<ApplicationReadyEvent> {

    private final Closet closet;

    @Autowired
    Article2Repository repository;

    @Autowired
    public MainScreen(Closet closet) {
        this.closet = closet;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        repository.saveArticle(new Article2("t-shirt", "blue", "XXL", "Lacoste"));
        repository.saveArticle(new Article2("t-shirt", "white", "XL", "Lacoste"));
        repository.saveArticle(new Article2("t-shirt", "orange", "L", "Lacoste"));
        repository.saveArticle(new Article2("t-shirt", "silver", "M", "Lacoste"));
        repository.saveArticle(new Article2("t-shirt", "taupe", "S", "Lacoste"));

        List<Article2> articles = repository.readArticleByType("t-shirt");

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
                        System.out.println("*         Du hast noch keine Kleidungsstücke         *");
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
                            System.out.println("*            Wonach möchtest du suchen?              *");
                            System.out.println("*                       ...                          *");
                            System.out.println("******************************************************");
                            searchParameter = scanner.next();
                            closet.searchArticle(searchArticleSelection,searchParameter);
                        }

                    }

                }
                break;
                case 3: {
                    if (closet.getSizeOfMyArticles() == 0) {
                        System.out.println("******************************************************");
                        System.out.println("*         Du hast noch keine Kleidungsstücke         *");
                        System.out.println("******************************************************");
                    } else {
                        closet.showAllArticles();
                        System.out.println("******************************************************");
                        System.out.println("* Bitte gib die Stelle ein die gelöscht werden soll. *");
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

        } while (mainMenueSelection != 4);

        scanner.close();

    }

}
