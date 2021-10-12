package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ClosetController {

    private final Closet closet;

    @Autowired
    public ClosetController(Closet closet) {
        this.closet = closet;
    }

    @GetMapping("/articles")
    Set<Article> getAllArticles() {
        return closet.getMyArticles();
    }

}
