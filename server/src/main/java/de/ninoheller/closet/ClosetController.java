package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClosetController {

    private final Closet closet;

    @Autowired
    public ClosetController(Closet closet) {
        this.closet = closet;
    }

    /*  Tests

    @GetMapping("/closet/string")
    String getString(@RequestParam(required = false) String color){
        StringBuilder testString = new StringBuilder();
        testString.append("The color is : ");
        if (color!=null){
        testString.append(color);
        }
        return testString.toString();
    }

    @GetMapping("closet/array")
    Article[] getArticleArray(){
        Article[] articleArray = new Article[3];
        articleArray[0] = new Article("Jacke", "blau", "Zara", Article.getSizes("s"));
        articleArray[1] = new Article("Hose", "blau", "Zara", Article.getSizes("s"));
        articleArray[2] = new Article("Schuhe", "blau", "Zara", Article.getSizes("s"));
        return articleArray;
    }

    @GetMapping("closet/arraylist")
    Article[] getArticleArrayFromArrayList(){
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Jacke", "blau", "Zara", Article.getSizes("s")));
        articleList.add(new Article("Hose", "blau", "Zara", Article.getSizes("s")));
        articleList.add(new Article("Schuhe", "blau", "Zara", Article.getSizes("s")));


        return articleList.toArray(Article[]::new);
    }

    */



    @GetMapping("/closet")
    Closet getCloset(){
        return closet;
    }

    @GetMapping("closet/articles")
    Article[] getArticles(@RequestParam(required = false)String selection,String parameter, String comparator ){
        return closet.getArticle(selection,parameter,comparator);
    }

    @GetMapping("/articles/{articleId}")
    ResponseEntity<Article> getArticlesById(@PathVariable String articleId) {
        Article article = closet.getArticleById(articleId);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/closet/articles")
    Article addTestArticle(@RequestBody Article article){
        return closet.addArticle(article);
    }

    @PostMapping("/articles")
    ResponseEntity<?> addNewArticle(@RequestBody Article article) {
        Article newArticle = closet.addArticle(article);
        return ResponseEntity.created(URI.create("/articles/" + newArticle.getId())).build();
    }

    @DeleteMapping("/closet/articles")
    void deleteArticle(@RequestParam(required = true) String id) {
        closet.removeArticle(id);
    }
}
