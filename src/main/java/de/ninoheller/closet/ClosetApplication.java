package de.ninoheller.closet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ClosetApplication {

    @Autowired
    MainScreen mainScreen;

    public static void main(String[] args) {
        SpringApplication.run(ClosetApplication.class, args);
    }

    @PostConstruct
    public void init() {
        mainScreen.show();
    }

}
