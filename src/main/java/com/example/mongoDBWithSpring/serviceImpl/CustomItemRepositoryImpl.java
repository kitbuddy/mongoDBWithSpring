package com.example.mongoDBWithSpring.serviceImpl;

import com.example.mongoDBWithSpring.model.GroceryItem;
import com.example.mongoDBWithSpring.repository.ItemRepository;
import com.example.mongoDBWithSpring.service.CustomItemRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomItemRepositoryImpl implements CustomItemRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ItemRepository groceryItemRepo;

    @Override
    public void updateItemQuantity(String name, float newQuantity) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("quantity", newQuantity);

        UpdateResult result = mongoTemplate.updateFirst(query, update, GroceryItem.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }

    //CREATE
    public void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers7", "Bonny Cheese Crackers Plain7", 7, "snacks"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers8", "Bonny Cheese Crackers Plain", 8, "snacks"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers9", "Bonny Cheese Crackers Plain9", 9, "snacks"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet2", "Healthy Pearl Millet", 2, "millets"));

        System.out.println("Data creation complete...");
    }

    @Override
    public void updateCategoryName(String category) {

        // Change to this new value
        String newCategory = "munchies";

        // Find all the items with the category snacks
        List<GroceryItem> list = groceryItemRepo.findAll(category);

        list.forEach(item -> {
            // Update the category in each document
            item.setCategory(newCategory);
        });

        // Save all the items in database
        List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);

        if(itemsUpdated != null)
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
    }

    public List<String> getAllUniqueNames() {
        List<String> namesList = new ArrayList<>();

        List<GroceryItem> response = groceryItemRepo.findAll();

        /*namesList = response.stream()
                    .map(GroceryItem::getName).collect(Collectors.toSet())
                    .stream().collect(Collectors.toList());
*/

        namesList = new ArrayList<>(response.stream()
                .map(GroceryItem::getName).collect(Collectors.toSet()));

        return namesList;
    }
    public Set<String> getAllUniqueNamesWithString(String value) {
        Set<String> namesList;

        List<GroceryItem> response = groceryItemRepo.findAll();

        namesList = response.stream().map(GroceryItem::getName).filter(b -> b.contains(value))
                .collect(Collectors.toSet());
        return namesList;
    }
}
