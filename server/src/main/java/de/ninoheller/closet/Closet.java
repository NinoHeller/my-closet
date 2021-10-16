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
    public boolean searchArticle(int selection) {
        Scanner scanner = new Scanner(System.in);

        switch (selection) {// 1. by type 2. by color 3. by brand 4. by size 5. show all
            case 1: {
                Logger.print("Wonach möchtest du suchen?", "z.B. Jacke / Hose / Schuhe");
                String parameter = scanner.next();
                Logger.print("Wie soll sortiert werden?", "1. nach Farbe", "2. nach Marke", "3. nach Größe");
                int comparator = scanner.nextInt();
                if (comparator == 1) {
                    myArticles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYCOLOR
                                    .thenComparing(Article.Comperators.BYBRAND)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    myArticles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYBRAND
                                    .thenComparing(Article.Comperators.BYCOLOR)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    myArticles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYSIZE
                                    .thenComparing(Article.Comperators.BYBRAND)
                                    .thenComparing(Article.Comperators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                }
            }
            break;
            case 2: {
                Logger.print("Nach welcher Farbe möchtest du suchen?");
                String parameter = scanner.next();
                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Marke", "3. nach Größe");
                int comparator = scanner.nextInt();
                if (comparator == 1) {
                    myArticles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYTYPE
                                    .thenComparing(Article.Comperators.BYBRAND)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    myArticles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYBRAND
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    myArticles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYSIZE
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYBRAND))
                            .forEach(article -> System.out.println(article));
                }
            }
            break;
            case 3: {
                Logger.print("Nach welcher Marke möchtest du suchen?");
                String parameter = scanner.next();
                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Farbe", "3. nach Größe");
                int comparator = scanner.nextInt();
                if (comparator == 1) {
                    myArticles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYTYPE
                                    .thenComparing(Article.Comperators.BYCOLOR)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    myArticles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYCOLOR
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    myArticles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYSIZE
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                }
            }
            break;
            case 4: {
                Logger.print("Nach welcher Größe möchtest du suchen?", "s / m / l / xl");
                String parameter = scanner.next();
                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Farbe", "3. nach Marke");
                int comparator = scanner.nextInt();
                if (comparator == 1) {
                    myArticles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYTYPE
                                    .thenComparing(Article.Comperators.BYBRAND)
                                    .thenComparing(Article.Comperators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    myArticles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYCOLOR
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYBRAND))
                            .forEach(article -> System.out.println(article));
                } else {
                    myArticles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comperators.BYBRAND
                                    .thenComparing(Article.Comperators.BYTYPE)
                                    .thenComparing(Article.Comperators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                }
            }
            break;
            case 5: {
                Logger.print("Hier sind alle deine Kleidungsstücke.");
                myArticles.stream()
                        .sorted(Article.Comperators.BYTYPE
                                .thenComparing(Article.Comperators.BYCOLOR
                                        .thenComparing(Article.Comperators.BYBRAND
                                                .thenComparing(Article.Comperators.BYSIZE))))
                        .forEach(article -> System.out.println(article));
            }
            break;

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
