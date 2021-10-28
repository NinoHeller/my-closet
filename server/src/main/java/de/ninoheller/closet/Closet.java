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

    // finds articles from the closet
    public Article[] getArticle (String selection, String parameter, String comparator) {
        switch (selection) {// 1. by type 2. by color 3. by brand 4. by size 5. show all
            case "1": {
                if (comparator.equals("1")) {
                    return articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYBRAND, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else if (comparator.equals("2")) {
                    return articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else {
                    return articles.stream()
                            .filter(article -> article.getType().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR))
                            .toArray(Article[]::new);
                }
            }
            case "2": {
                if (comparator.equals("1")) {
                    return articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYBRAND, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else if (comparator.equals("2")) {
                    return articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYTYPE, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else {
                    return articles.stream()
                            .filter(article -> article.getColor().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYTYPE, Article.Comparators.BYBRAND))
                            .toArray(Article[]::new);
                }
            }
            case "3": {
                if (comparator.equals("1")) {
                    return articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else if (comparator.equals("2")) {
                    return articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYTYPE, Article.Comparators.BYSIZE))
                            .toArray(Article[]::new);
                } else {
                    return articles.stream()
                            .filter(article -> article.getBrand().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYSIZE, Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR))
                            .toArray(Article[]::new);
                }
            }
            case "4": {
                if (comparator.equals("1")) {
                    return articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYTYPE, Article.Comparators.BYBRAND, Article.Comparators.BYCOLOR))
                            .toArray(Article[]::new);
                } else if (comparator.equals("2")) {
                    return articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYCOLOR, Article.Comparators.BYTYPE, Article.Comparators.BYBRAND))
                            .toArray(Article[]::new);
                } else {
                    return articles.stream()
                            .filter(article -> article.getSize().equalsIgnoreCase(parameter))
                            .sorted(Article.Comparators.merge(Article.Comparators.BYBRAND, Article.Comparators.BYTYPE, Article.Comparators.BYCOLOR))
                            .toArray(Article[]::new);
                }
            }
            case "5": {
                return articles.stream()
                        .toArray(Article[]::new);
            }
            default:{
                Article[] noArticles = new Article[0];
                return noArticles;
            }
        }
    }

    // removes an article from the closet
    public void removeArticle(String articleId) {
        Article articleToRemove = articles.stream()
                .filter(article -> article.getId().equals(articleId))
                .findFirst()
                .orElse(null);

        if (articleToRemove!=null) {
            int index = articles.indexOf(articleToRemove);

            articles.remove(index);
            System.out.println("Artikel wurde entfernt.");
        }else{
            System.out.println("Kein Artikel mit dieser ID vorhanden.");
        }
    }


    // getters
    public List<Article> getAllArticles() {
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
