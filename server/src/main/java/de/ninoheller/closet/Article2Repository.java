package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Article2Repository implements ApplicationListener<ApplicationStartedEvent> {

    public static final String COLLECTION_NAME = "articles";
    private final MongoTemplate mongoTemplate;

    @Autowired
    public Article2Repository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    Article2 saveArticle(Article2 article) {
        return mongoTemplate.save(article, COLLECTION_NAME);
    }

    //FIXME this does not work
    List<Article2> readArticleByType(String type) {
        Query query = Query.query(Criteria.where("type").is(type));
        return mongoTemplate.find(query, Article2.class, COLLECTION_NAME);
    }


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        mongoTemplate.createCollection(COLLECTION_NAME);
    }
}
