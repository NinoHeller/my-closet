package de.ninoheller.closet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

public class Article2 {

    @Id
    private String id = UUID.randomUUID().toString();

    @Indexed
    private final String type;
    private final String color;
    private final String size;
    private final String brand;

    //Constructor
    public Article2(String type, String color, String size, String brand) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }
}
