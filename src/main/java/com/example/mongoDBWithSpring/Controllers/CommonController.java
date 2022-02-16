package com.example.mongoDBWithSpring.Controllers;

import com.example.mongoDBWithSpring.model.GroceryItem;
import com.example.mongoDBWithSpring.repository.ItemRepository;
import com.example.mongoDBWithSpring.serviceImpl.CustomItemRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@Slf4j
public class CommonController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomItemRepositoryImpl customItemRepository;

    @GetMapping("/getAll/{category}")
//    @ResponseBody
    public List<GroceryItem> getAllItemsFromGroceryRepoByCategory(@PathVariable String category) {
        log.info("Get All method called from getAllItemsFromGroceryRepoByCategory controller");
        return itemRepository.findAll(category);

    }

    @GetMapping("/all")
    public List<GroceryItem> findAllItemsFromGroceryRepoByCategory() {
        log.info("-All method called from findAllItemsFromGroceryRepoByCategory controller");
        return itemRepository.findAll();
    }

    @GetMapping("/create")
    public void createAllItemsInRepo() {
        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
        customItemRepository.createGroceryItems();
    }


}
