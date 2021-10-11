# Tasks
Hint: Entweder das Markdown Plugin von IntelliJ installieren oder einen Markdown Viewer auf deinem Rechner

# OO
* Article2 in Article überführen, konsolideren (MongoDB erstmal ignorieren)

* Closet.myArticles soll keine Duplikate mehr beinhalten
  * Hierzu bitte java.util.collection.Set anschauen, sowie Object.equals() und Object.hashCode() 

* `private final String size` als Enum (S, M, L, XL) abbilden

* `toString()` auf Article sinnvoll implementieren und über `println(article)` testen.

* Articles sortiert nach stdout printen
  * hierzu gibt es 2 Optionen, die jeder Java-Dev kennen sollte: das Interface `Comparable` und Comparators

* alle for loops in Streams konvertieren

# API (für später)
Controller für
* get-article-by-id
* GET /articles/{id}
* Article anlegen
  * POST /articles legt einen neuen Artikel an, der dann über GET /articles/{id} gelesen werden kann
* find articles (Suchfunktion)
  * GET /articles?size=xxx&color=xxx&limitxx liefert die ersten `limit` Einträge, in `size` xxx und `color` yyy
