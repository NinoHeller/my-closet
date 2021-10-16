package de.ninoheller.closet;

import java.util.ArrayList;
import java.util.List;

public class TestArticles {
    public List<Article> testArticles = new ArrayList<>();

    public TestArticles() {
        this.testArticles.add(new Article("Jacke", "blau", "Zara", Article.getSizes("s")));
        this.testArticles.add(new Article("Jacke", "grau", "Boss", Article.getSizes("s")));
        this.testArticles.add(new Article("Jacke", "rot", "Lacoste", Article.getSizes("m")));
        this.testArticles.add(new Article("Jacke", "schwarz", "H&M", Article.getSizes("m")));
        this.testArticles.add(new Article("Jacke", "schwarz", "Boss", Article.getSizes("s")));
        this.testArticles.add(new Article("Jacke", "schwarz", "Zara", Article.getSizes("s")));
        this.testArticles.add(new Article("Jacke", "weiß", "Zara", Article.getSizes("s")));
        this.testArticles.add(new Article("Jacke", "weiß", "Boss", Article.getSizes("m")));
        this.testArticles.add(new Article("Jacke", "weiß", "H&M", Article.getSizes("m")));
        this.testArticles.add(new Article("Jacke", "weiß", "Adidas", Article.getSizes("m")));
        this.testArticles.add(new Article("Hose", "blau", "Zara", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "grau", "Boss", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "grau", "Boss", Article.getSizes("m")));
        this.testArticles.add(new Article("Hose", "grau", "Boss", Article.getSizes("l")));
        this.testArticles.add(new Article("Hose", "grau", "H&M", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "schwarz", "Zara", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "schwarz", "Boss", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "schwarz", "H&M", Article.getSizes("s")));
        this.testArticles.add(new Article("Hose", "schwarz", "Nike", Article.getSizes("s")));

    }


}
