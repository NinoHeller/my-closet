#Danke für die Aufgaben - hat auf jeden Fall viel gebracht! :)

# Tasks
* Articles sortiert nach stdout printen
  * hierzu gibt es 2 Optionen, die jeder Java-Dev kennen sollte: das Interface `Comparable` und Comparators
  * * <b>ich habe die sortierung direkt im stream vorgenommen, ist das in Ordnung so?</b>
  
Das passt so, ja. Wir machen aber jetzt noch eine Steigerung:
Wir wollen ja Artikel manchmal nach unterschiedlichen Kriterien sortieren: Größe, Preis, alphabetisch,...
Hierzu machen wir jetzt ein einen Comparator, die sich kombinieren (nesten) lassen:

```java
import java.util.Comparator;

class Article {

  static class Comparator {
    static final Comparator<Article> ALPHABETICALLY = //TODO implement
    static final Comparator<Article> BY_SIZE = //TODO implement
    
    static Comparator<Article> merge(Comparator<Article> comp1, Comparator<Article> comp2) {
        //TODO implement a comparator, that combines comp1 and 2
    }
  }
}

```

***
* alle for loops in Streams konvertieren
  * * <b>erledigt und getestet</b>
***
  
Hierzu habe ich noch eine Task erfasst (s. TODOs). Am Ende soll es keine for loops mehr geben. 

***
* Polymorphismus:
Wir ändern nun die Modellierung des Articles weg von einem generischen Article hin zu konkreten Implementierungen:
Hierzu führen wir ein Interface Article ein (bzw. ersetzen die Klasse):
```
public interace Article {

	//Attributes
	String getType();
	String getColor();
	String getBrand();
	String getSize();
	String isAccessory();

```

Und dann gibt konkrete Ausprägungen eine Artikels:
* Shirt: hat zusätzlich noch die option boolean islongSleeve();
* Trousers: hat zusätzlich noch die option Trouser.Style getStyle(); 
  * wobei Style ein enum mit den Werten SlimFit, Tapered, Leggins, BootCut ist
* Tie: keine weiteren Attribute
* Belt: keine weiteren Attribute

***


#Fragen

#Artikel löschen
* um ein Objekt aus einem Set zu entfernen, muss man ja ein explizites Objekt an die remove methode übergeben und keinen Index
* Dafür müsste ich ja nach der Ausgabe aller enthaltenen Artikel, den User bitten alle Attribute anzugeben von dem Artikel den er entfernen möchte
* um damit genau das Objekt angeben zu können, welches entfernt werden soll
* geht das eleganter über den hashcode z.B.?
* Den ich dann mit einer Indexvariable verknüpfen würde, um den User nach dem Index zu fragen den er entfernen möchte?
***

Korrekt, es gibt keinen Index bei hash-basierten Collections. 
Schau dir mal set.removeIf(Predicate...) an. Damit kann man 1 oder mehrere Objekte aus deinem Set entfernen. 
Hat natürlich eine andere Performance als Index-basierter Zugriff.

# Exceptionhandling
* Mainscreen
  * ich möchte dem Nutzer über den zweiten try block nochmal eine Chance geben
  * dann wird auch das showMainMenue nochmal aufgerufen, aber er überspringt den Scanner 
  * und springt direkt in die zweite Exception e2 -> das verstehe ich nicht so richtig
***

* public static Article createArticle ()
  * ich wollte über den try block abfangen, wenn die eingabe nicht in der enum enthalten ist
  * aber wenn ich die Zeile über dem try catch block auskommentiere und dafür den try catch block nehme
  * dann scheint die Variable size nicht mehr static zu sein
  * muss ich dann den neuen Artikel innerhalb des try catch blocks erstellen?
***

Wir schauen uns das Thema Exception handling beim nächsten Mal an.

# API (für später)
Controller für
* get-article-by-id
* GET /articles/{id}
* Article anlegen
  * POST /articles legt einen neuen Artikel an, der dann über GET /articles/{id} gelesen werden kann
* find articles (Suchfunktion)
  * GET /articles?size=xxx&color=xxx&limitxx liefert die ersten `limit` Einträge, in `size` xxx und `color` yyy
