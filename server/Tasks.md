#Danke für die Aufgaben - hat auf jeden Fall viel gebracht! :)

# Tasks
* Article2 in Article überführen, konsolideren (MongoDB erstmal ignorieren)
  * * <b>erledigt und getestet</b>
***

* Closet.myArticles soll keine Duplikate mehr beinhalten
  * Hierzu bitte java.util.collection.Set anschauen, sowie Object.equals() und Object.hashCode() 
  * * <b>erledigt und getestet</b>
***
* `private final String size` als Enum (S, M, L, XL) abbilden
  * * <b>erledigt und getestet</b>
***

* `toString()` auf Article sinnvoll implementieren und über `println(article)` testen.
  * * <b>erledigt und getestet</b>
***
  
* Articles sortiert nach stdout printen
  * hierzu gibt es 2 Optionen, die jeder Java-Dev kennen sollte: das Interface `Comparable` und Comparators
  * * <b>ich habe die sortierung direkt im stream vorgenommen, ist das in Ordnung so?</b>
***
* alle for loops in Streams konvertieren
  * * <b>erledigt und getestet</b>
***
#Fragen

#Artikel löschen
* um ein Objekt aus einem Set zu entfernen, muss man ja ein explizites Objekt an die remove methode übergeben und keinen Index
* Dafür müsste ich ja nach der Ausgabe aller enthaltenen Artikel, den User bitten alle Attribute anzugeben von dem Artikel den er entfernen möchte
* um damit genau das Objekt angeben zu können, welches entfernt werden soll
* geht das eleganter über den hashcode z.B.?
* Den ich dann mit einer Indexvariable verknüpfen würde, um den User nach dem Index zu fragen den er entfernen möchte?
***

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
  

# API (für später)
Controller für
* get-article-by-id
* GET /articles/{id}
* Article anlegen
  * POST /articles legt einen neuen Artikel an, der dann über GET /articles/{id} gelesen werden kann
* find articles (Suchfunktion)
  * GET /articles?size=xxx&color=xxx&limitxx liefert die ersten `limit` Einträge, in `size` xxx und `color` yyy
