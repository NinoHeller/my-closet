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
    private final DummyArticles dummyArticles;


    @Autowired
    public MainScreen(Closet closet, DummyArticles dummyArticles) {
        this.closet = closet;
        this.dummyArticles = dummyArticles;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        //Add dummy articles
        for (int i = 0; i < dummyArticles.dummyList.size(); i++) {
            closet.addArticle(dummyArticles.dummyList.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int mainMenueSelection;
        int searchArticleSelection;
        int indexSelection;
        do {
            MainMenue.showMainMenue();
            try {
                mainMenueSelection = scanner.nextInt();
            } catch (Exception e1) {
                Logger.print("Bitte nur Zahlen eingeben!");
                try {
                    MainMenue.showMainMenue();
                    mainMenueSelection = scanner.nextInt();
                } catch (Exception e2) {
                    Logger.print("Ok dann nicht!");
                    mainMenueSelection = 4;
                }
            }
            switch (mainMenueSelection) {// 1. add article 2. search article 3. delete article
                case 1 -> closet.addArticle(Article.createArticle());


                case 2 -> {
                    if (closet.getSizeOfMyArticles() == 0) {
                        Logger.print("Du hast noch keine Kleidungsstücke.");
                    } else {
                        SearchMenue.showSearchMenue();
                        searchArticleSelection = scanner.nextInt();
                        if (searchArticleSelection > 5) {
                            Logger.print("Diese Auswahl gibt es nicht!");
                        } else {
                            closet.searchArticle(searchArticleSelection);
                        }
                    }
                }
                case 3 -> {
                    if (closet.getSizeOfMyArticles() == 0) {
                        Logger.print("Du hast noch keine Kleidungsstücke.");
                    } else {
                        closet.searchArticle(5);
                        Logger.print("Welches Kleidungsstück möchtest du entfernen?");
                        indexSelection = scanner.nextInt();
                        if (indexSelection > closet.getSizeOfMyArticles()) {
                            Logger.print("Diese Stelle gibt es nicht");
                        } else {
                            closet.removeArticle(indexSelection);
                        }
                    }
                }
                case 4 -> Logger.print("Auf Wiedersehen! :)");
                default -> Logger.print("Diese Auswahl gibt es nicht!");
            }
        } while (mainMenueSelection != 4);
        scanner.close();
    }
}
