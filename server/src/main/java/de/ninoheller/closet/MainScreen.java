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
            try {
                mainMenueSelection = scanner.nextInt();
            }catch (Exception e1){
                Logger.print("Bitte nur Zahlen eingeben!");
                try{
                    MainMenue.showMainMenue();
                    mainMenueSelection = scanner.nextInt();
                }catch (Exception e2){
                    Logger.print("Ok dann nicht!");
                    mainMenueSelection = 4;
                }
            }

            switch (mainMenueSelection) {
                case 1: {
                    closet.addArticle(Article.createArticle());
                }
                break;
                case 2: {
                    if (closet.getSizeOfMyArticles() == 0) {
                        Logger.print("Du hast noch keine Kleidungsstücke.");
                    } else {
                        SearchArticle.searchArticle();
                        searchArticleSelection = scanner.nextInt();
                        if (searchArticleSelection == 5) {
                            closet.showAllArticles();
                        } else if (searchArticleSelection > 5) {
                            Logger.print("Diese Auswahl gibt es nicht!");

                        } else {
                            Logger.print("Wonach möchtest du suchen?","...");
                            searchParameter = scanner.next();
                            closet.searchArticle(searchArticleSelection,searchParameter);
                        }
                    }
                }
                break;
                case 3: {
                    if (closet.getSizeOfMyArticles() == 0) {
                        Logger.print("Du hast noch keine Kleidungsstücke.");
                    } else {
                        closet.showAllArticles();
                        Logger.print("Welches Kleidungsstück möchtest du entfernen?");
                        indexSelection = scanner.nextInt();

                        if (indexSelection > closet.getSizeOfMyArticles()) {
                            Logger.print("Diese Stelle gibt es nicht");
                        } else {
                            closet.removeArticle(indexSelection);
                        }
                    }

                }
                break;
                case 4: {
                    Logger.print("Auf Wiedersehen! :)");
                }
                break;
                default: {
                    Logger.print("Diese Auswahl gibt es nicht!");
                }
                break;
            }

        } while (mainMenueSelection != 4);

        scanner.close();

    }

}
