package com.example.mongoDBWithSpring;

import com.example.mongoDBWithSpring.model.GroceryItem;
import com.example.mongoDBWithSpring.service.CustomItemRepository;
import com.example.mongoDBWithSpring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbWithSpringApplication.class, args);
	}



}
