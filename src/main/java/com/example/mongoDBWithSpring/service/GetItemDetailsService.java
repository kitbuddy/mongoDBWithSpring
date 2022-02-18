package com.example.mongoDBWithSpring.service;

import com.example.mongoDBWithSpring.model.GroceryItem;

import java.util.List;
import java.util.Set;

public interface GetItemDetailsService {

    Set<String> getGroceryItemsNames();
    GroceryItem getGroceryItemByName(String name);
    List<GroceryItem> getItemsByCategory(String category);
    long findCountOfGroceryItems();
    void updateItemQuantity(String name, float newQuantity);
    void deleteGroceryItem(String id);
}
