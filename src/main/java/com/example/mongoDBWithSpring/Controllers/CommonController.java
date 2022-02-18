package com.example.mongoDBWithSpring.Controllers;

import com.example.mongoDBWithSpring.model.GroceryItem;
import com.example.mongoDBWithSpring.repository.ItemRepository;
import com.example.mongoDBWithSpring.service.GetItemDetailsService;
import com.example.mongoDBWithSpring.serviceImpl.CustomItemRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Slf4j
public class CommonController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomItemRepositoryImpl customItemRepository;

    GetItemDetailsService getItemDetailsService;

    public CommonController(GetItemDetailsService getItemDetailsService) {
        this.getItemDetailsService = getItemDetailsService;
    }

    @GetMapping("/getAll/{category}")
    public List<GroceryItem> getAllItemsFromGroceryRepoByCategory(@PathVariable String category) {
        log.info("Get All method called from getAllItemsFromGroceryRepoByCategory controller");
        return itemRepository.findAll(category);

    }

    @GetMapping("/all")
    public List<GroceryItem> findAllItemsFromGroceryRepoByCategory() {
        log.info("-All method called from findAllItemsFromGroceryRepoByCategory controller");
        return itemRepository.findAll();
    }

    @GetMapping("/allUniqueNames")
    public List<String> findAllallUniqueNames() {
        log.info("-All method called from findAllItemsFromGroceryRepoByCategory controller");
        customItemRepository.createGroceryItems();
        return customItemRepository.getAllUniqueNames();
    }

    @GetMapping("/allUniqueNamesWithString/{name}")
    public Set<String> findAllallUniqueNamesWithString(@PathVariable String name) {
        log.info("-All method called from findAllItemsFromGroceryRepoByCategory controller");
        customItemRepository.createGroceryItems();
        return customItemRepository.getAllUniqueNamesWithString(name);
    }

    @GetMapping("/setOfGroceries")
    public Set<String> getSetOfItemsFromGroceryRepoByCategory() {
        log.info("-All method called from findAllItemsFromGroceryRepoByCategory controller");
        return getItemDetailsService.getGroceryItemsNames();
    }

    @GetMapping("/create")
    public void createAllItemsInRepo() {
        log.info("-------------CREATE GROCERY ITEMS-------------------------------\n");
        customItemRepository.createGroceryItems();
    }

    @GetMapping("/getItemCount")
    public long getCountOfGroceryItems(){
        log.info("\n-----------GET CountOfGroceryItems---------------------------------\n");
        long count = getItemDetailsService.findCountOfGroceryItems();
        log.info("Number of documents in the collection: " + count);
        return count;
    }

    @PostMapping(path = "/getItemByName",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getItemByName(@RequestParam(defaultValue = "Whole Wheat Biscuit") String name){
        log.info("\n-----------GET ITEMS BY NAME---------------------------------\n");
        getItemDetailsService.getGroceryItemByName(name);
    }

    @GetMapping("/getItem/{category}")
    public List<GroceryItem> getItemByCategory(@PathVariable String category){
        log.info("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");
        return  getItemDetailsService.getItemsByCategory(category);
    }

    @PostMapping("/update/{category}/{quantity}")
    public void getItemByCategory(@PathVariable String category, float quantity){
        log.info("\n-----------GET ITEMS BY CATEGORY AND QUANTITY---------------------------------\n");
        getItemDetailsService.updateItemQuantity(category, quantity);
    }

    @PostMapping("/delete/{id}")
    public void deleteGroceryItems(@PathVariable String id){
        log.info("\n----------DELETE A GROCERY ITEM----------------------------------\n");
//        deleteGroceryItem("Kodo Millet");
        getItemDetailsService.deleteGroceryItem(id);
    }

    public void callMapsAPIForTesting() {

    }

}
