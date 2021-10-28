package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class MainScreen implements ApplicationListener<ApplicationReadyEvent> {

    private final DummyArticles dummyArticles;
    private final RestTemplate restTemplate;


    @Autowired
    public MainScreen(DummyArticles dummyArticles, RestTemplate restTemplate) {
        this.dummyArticles = dummyArticles;
        this.restTemplate = restTemplate;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        /*  Tests
        URI lastUri = null;
        //Add dummy articles
        for (int i = 0; i < dummyArticles.dummyList.size(); i++) {
            //call server with new Article via HTTP
            closet.addArticle(dummyArticles.dummyList.get(i));
            Article article = dummyArticles.dummyList.get(i);
            lastUri = restTemplate.postForLocation("http://localhost:8080/articles", article);
            System.out.println("created new article at resource location " + lastUri);
        }


        String url = "http://localhost:8080" + lastUri;
        ResponseEntity<Article> response = restTemplate.getForEntity(url, Article.class);

        System.out.println(response.getStatusCode());
        Article body = response.getBody();
        System.out.println(body);
        System.out.println(response.getHeaders());

        Closet responseTest = restTemplate.getForObject("http://localhost:8080/closet", Closet.class);
        responseTest.getArticles()
                .stream()
                .filter(article -> article.getBrand().equalsIgnoreCase("H&M"))
                .forEach(article -> System.out.println(article));


        String testString = restTemplate.getForObject("http://localhost:8080/closet/string", String.class);
        System.out.println(testString);

        String testStringColor = restTemplate.getForObject("http://localhost:8080/closet/string?color=red", String.class);
        System.out.println(testStringColor);


        Arrays.stream(restTemplate.getForObject("http://localhost:8080/closet/array", Article[].class)).toList().forEach(article -> System.out.println(article));

        System.out.println("*********************************************************************************************");

        Arrays.stream(restTemplate.getForObject("http://localhost:8080/closet/arraylist", Article[].class)).toList().forEach(article -> System.out.println(article));

        */


        // fill Closet with dummy articles
        for (int i = 0; i < dummyArticles.dummyList.size(); i++) {
            restTemplate.postForObject("http://localhost:8080/closet/articles", dummyArticles.dummyList.get(i), Article.class);
        }

        Scanner scanner = new Scanner(System.in);
        StringBuilder url = new StringBuilder();
        int mainMenueSelection;
        int searchArticleSelection;
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
                case 1 -> {
                    url.append("http://localhost:8080/closet/articles");
                    restTemplate.postForObject(url.toString(), Article.createArticle(), Article.class);
                    break;
                }

                case 2 -> {

                    SearchMenue.showSearchMenue();
                    searchArticleSelection = scanner.nextInt();

                    if (searchArticleSelection > 5) {
                        Logger.print("Diese Auswahl gibt es nicht!");
                        break;
                    } else {
                        switch (searchArticleSelection) {// 1. by type 2. by color 3. by brand 4. by size 5. show all
                            case 1: {
                                url.append("http://localhost:8080/closet/articles?selection=1");
                                Logger.print("Wonach möchtest du suchen?", "z.B. Jacke / Hose / Schuhe");
                                url.append("&&parameter=");
                                url.append(scanner.next());
                                Logger.print("Wie soll sortiert werden?", "1. nach Farbe", "2. nach Marke", "3. nach Größe");
                                url.append("&&comparator=");
                                url.append(scanner.next());
                                Arrays.stream(restTemplate.getForObject(url.toString(), Article[].class))
                                        .toList()
                                        .forEach(article -> System.out.println(article));
                                break;
                            }
                            case 2: {
                                url.append("http://localhost:8080/closet/articles?selection=2");
                                Logger.print("Nach welcher Farbe möchtest du suchen?");
                                url.append("&&parameter=");
                                url.append(scanner.next());
                                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Marke", "3. nach Größe");
                                url.append("&&comparator=");
                                url.append(scanner.next());
                                Arrays.stream(restTemplate.getForObject(url.toString(), Article[].class))
                                        .toList()
                                        .forEach(article -> System.out.println(article));
                                break;
                            }
                            case 3: {
                                url.append("http://localhost:8080/closet/articles?selection=3");
                                Logger.print("Nach welcher Marke möchtest du suchen?");
                                url.append("&&parameter=");
                                url.append(scanner.next());
                                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Farbe", "3. nach Größe");
                                url.append("&&comparator=");
                                url.append(scanner.next());
                                Arrays.stream(restTemplate.getForObject(url.toString(), Article[].class))
                                        .toList()
                                        .forEach(article -> System.out.println(article));
                                break;
                            }
                            case 4: {
                                url.append("http://localhost:8080/closet/articles?selection=4");
                                Logger.print("Nach welcher Größe möchtest du suchen?", "s / m / l / xl");
                                url.append("&&parameter=");
                                url.append(scanner.next());
                                Logger.print("Wie soll sortiert werden?", "1. nach Typ", "2. nach Farbe", "3. nach Marke");
                                url.append("&&comparator=");
                                url.append(scanner.next());
                                Arrays.stream(restTemplate.getForObject(url.toString(), Article[].class))
                                        .toList()
                                        .forEach(article -> System.out.println(article));
                                break;
                            }
                            case 5: {
                                url.append("http://localhost:8080/closet/articles?selection=5");
                                Logger.print("Hier sind alle deine Kleidungsstücke.");
                                Arrays.stream(restTemplate.getForObject(url.toString(), Article[].class))
                                        .toList()
                                        .forEach(article -> System.out.println(article));
                                break;
                            }
                        }
                    }
                }

                case 3 -> {
                    Closet closet = restTemplate.getForObject("http://localhost:8080/closet", Closet.class);
                    if (closet.getSizeOfMyArticles() == 0) {
                        Logger.print("Du hast noch keine Kleidungsstücke.");
                        break;
                    } else {
                        Logger.print("Hier sind alle deine Kleidungsstücke.");
                        closet.getAllArticles()
                                .stream()
                                .forEach(article -> System.out.println(article));
                        Logger.print("Bitte gib die ID ein die du löschen möchtest.");
                        String ID = scanner.next();
                        restTemplate.delete("/closet/articles/" + ID, String.class);
                        break;
                    }
                }
                case 4 -> Logger.print("Auf Wiedersehen! :)");
                default -> Logger.print("Diese Auswahl gibt es nicht!");
            }
        } while (mainMenueSelection != 4);
        scanner.close();
    }
}
