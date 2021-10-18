package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
public class ClosetController {

    private final Closet closet;

    @Autowired
    public ClosetController(Closet closet) {
        this.closet = closet;
    }

    @GetMapping("/articles")
    List<Article> getAllArticles() {
        return closet.getArticles();
    }


    @PostMapping("/articles")
    ResponseEntity<?> addNewArticle(@RequestBody Article article) {
        Article newArticle = closet.addArticle(article);
        return ResponseEntity.created(URI.create("/articles/" + newArticle.getId())).build();
    }

    @GetMapping("/articles/{articleId}")
    ResponseEntity<Article> getArticles(@PathVariable String articleId) {
        Article article = closet.getArticleById(articleId);
        return ResponseEntity.ok(article);
    }
}
