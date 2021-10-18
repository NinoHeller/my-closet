package de.ninoheller.closet;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
class Closet {
    // Attributes
    private List<Article> articles;

    // Constructor
    Closet() {
        articles = new ArrayList<>();
    }

    // methods

    // adds an article to the closet
    public Article addArticle(Article newArticle) {
        articles.add(newArticle);
        return newArticle;
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
                    articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYBRAND, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR))
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
                    articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYBRAND, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYTYPE, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYTYPE, Article.Comparators.BYBRAND))
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
                    articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYTYPE, Article.Comparators.BYSIZE))
                            .forEach(article -> System.out.println(article));
                } else {
                    articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR))
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
                    articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                } else if (comparator == 2) {
                    articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYTYPE, Article.Comparators.BYBRAND))
                            .forEach(article -> System.out.println(article));
                } else {
                    articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR))
                            .forEach(article -> System.out.println(article));
                }
            }
            break;
            case 5: {
                Logger.print("Hier sind alle deine Kleidungsstücke.");
                articles.stream()
                        .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR, Article.Comparators.BYBRAND))
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
    public List<Article> getArticles() {
        return articles;
    }

    public int getSizeOfMyArticles() {
        return articles.size();
    }

    public Article getArticleById(String articleId) {
        return articles.stream()
                .filter(article -> article.getId().equals(articleId))
                .findFirst()
                .orElse(null);

    }
}
