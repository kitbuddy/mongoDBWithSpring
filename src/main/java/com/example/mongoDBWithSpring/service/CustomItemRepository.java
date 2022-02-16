package com.example.mongoDBWithSpring.service;

public interface CustomItemRepository {

    void updateItemQuantity(String name, float newQuantity);
    void createGroceryItems();
    void showAllGroceryItems();

}
