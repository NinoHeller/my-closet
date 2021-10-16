package de.ninoheller.closet;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Article {

    //Attributes
    private final String type;
    private final String color;
    private final String brand;
    private final Sizes size;

    private enum Sizes {s, m, l, xl}

    ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(getType(), article.getType()) && Objects.equals(getColor(), article.getColor()) && Objects.equals(getBrand(), article.getBrand()) && getSize() == article.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getColor(), getBrand(), getSize());
    }

    //Constructor

    public Article(String type, String color, String brand, Sizes size) {
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.size = size;
    }

    //Comparators
    static class Comperators {
        static final Comparator<Article> BYTYPE = Comparator.comparing(Article::getType);
        static final Comparator<Article> BYCOLOR = Comparator.comparing(Article::getColor);
        static final Comparator<Article> BYBRAND = Comparator.comparing(Article::getBrand);
        static final Comparator<Article> BYSIZE = Comparator.comparing(Article::getSize);

        static Comparator<Article> merge(Comparator<Article> comparator1, Comparator<Article> comparator2, Comparator<Article> comparator3){
            Comparator<Article> comparator;
            return  comparator = comparator1.thenComparing(comparator2).thenComparing(comparator3);
        }

    }

    //Methods

    // creates an article
    public static Article createArticle() {
        Scanner scanner = new Scanner(System.in);

        Logger.print("Ok - Was möchtest du hinzufügen?", "z.B. Jacke / Hose / T-Shirt", "...");
        String type = scanner.next();
        Logger.print("Ok - Welche Farbe hat das Kleidungsstück?", "...");
        String color = scanner.next();
        Logger.print("Ok - Von welcher Marke ist das Kleidungsstück?", "...");
        String brand = scanner.next();
        Logger.print("Ok - Welche Größe hat das Kleidungsstück?", "s, m, l oder xl");
        Sizes size = Sizes.valueOf(scanner.next().toLowerCase(Locale.ROOT));
		/*try {
			String size = sizes.valueOf(scanner.next().toLowerCase(Locale.ROOT)).toString();
		}catch (Exception e1){
			System.out.println("Bitte nur die vorgegebenen Größen wählen");
			try{
				String size = sizes.valueOf(scanner.next().toLowerCase(Locale.ROOT)).toString();
			}catch (Exception e2){
				System.out.println("Diese Größe gibt es nicht! Die Größe des Artikels wurde auf s festgelegt");
				String size = sizes.valueOf("s").toString();
			}
		}*/
        Logger.print("Ok - Dein Kleidungsstück wurde aufgehangen! :)");

        Article newArticle = new Article(type, color, brand, size);

        return newArticle;
    }


    @Override
    public String toString() {
        return "******************************************************\n"
                + "Dieser Artikel ist ein(e) " + type + "\n" + "In der Farbe " + color + "\n" + "Von der Marke " + brand + "\n" + "In der Größe " + size + "\n"
                + "******************************************************\n";
    }

    //getters
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size.toString();
    }

    public static Sizes getSizes(String size) {
        return Sizes.valueOf(size);
    }
}
