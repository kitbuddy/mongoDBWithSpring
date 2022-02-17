package com.example.mongoDBWithSpring.serviceImpl;

import com.example.mongoDBWithSpring.model.GroceryItem;
import com.example.mongoDBWithSpring.repository.ItemRepository;
import com.example.mongoDBWithSpring.service.CustomItemRepository;
import com.example.mongoDBWithSpring.service.GetItemDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetItemDetailsServiceImpl implements GetItemDetailsService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomItemRepository customRepo;

    @Override
    public Set<String> getGroceryItemsNames() {

        List<GroceryItem> listOfGroceries = itemRepository.findAll();

        Set<String> setOfGroceries = listOfGroceries.stream().map(a -> a.getName()).collect(Collectors.toSet());
        return setOfGroceries;
    }

    @Override
    public void getGroceryItemByName(String name) {
        log.info("Getting item by name: " + name);
        GroceryItem item = itemRepository.findItemByName(name);
        log.info(item.toString());
    }

    @Override
    public List<GroceryItem> getItemsByCategory(String category) {
        log.info("Getting items for the category " + category);
        List<GroceryItem> list = itemRepository.findAll(category);

        list.forEach(item -> log.info("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
        return list;
    }

    @Override
    public long findCountOfGroceryItems() {
        long count = itemRepository.count();
        log.info("Number of documents in the collection: " + count);
        return count;
    }

    @Override
    public void updateItemQuantity(String name, float newQuantity) {
        log.info("Updating quantity for " + name);
        customRepo.updateItemQuantity(name, newQuantity);
    }

    @Override
    public void deleteGroceryItem(String id) {
        itemRepository.deleteById(id);
        log.info("Item with id " + id + " deleted...");
    }
    public void printAllGroceryItems() {
        itemRepository.findAll().forEach(item -> log.info(item.toString()));
    }
}
