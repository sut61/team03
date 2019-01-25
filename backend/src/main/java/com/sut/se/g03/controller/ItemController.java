package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {
    @Autowired private final ItemRepository itemRepository;
    @Autowired private ShopRepository shopRepository;

    ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/Items")
    public Collection<Item> items() {
        return itemRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Item/new/{itemName}/{itemNum}/{price}")
    public Item newItem(@PathVariable String itemName, @PathVariable Integer itemNum, @PathVariable Integer price) {
        Item newItem = new Item();
        newItem.setItemName(itemName);
        newItem.setItemNum(itemNum);
        newItem.setPrice(price);
        return itemRepository.save(newItem);
    }
}
