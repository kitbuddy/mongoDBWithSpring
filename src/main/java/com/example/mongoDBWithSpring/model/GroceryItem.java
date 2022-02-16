package com.example.mongoDBWithSpring.model;


import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
public class GroceryItem {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public GroceryItem(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }


}
