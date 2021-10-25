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

    // removes an article from the closet
    public boolean removeArticle(String articleId) {
        int index;
        if(articles.stream()
                        .filter(article -> article.getId().equals(articleId))
                        .findFirst()
                        .orElse(null)==null){
            return false;
        }else{
            index = articles.indexOf(articles.stream()
                    .filter(article -> article.getId().equals(articleId))
                    .findFirst());
            articles.remove(index);
            return true;
        }
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
