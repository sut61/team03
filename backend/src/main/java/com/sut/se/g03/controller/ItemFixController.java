package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;

import com.sut.se.g03.entity.ItemFix;
import com.sut.se.g03.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemFixController {
    @Autowired private final ItemFixRepository itemFixRepository;

    ItemFixController(ItemFixRepository itemFixRepository) {
        this.itemFixRepository = itemFixRepository;
    }

    @GetMapping("/ItemFixes")
    public Collection<ItemFix> itemFixes() {
        return itemFixRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/ItemFixes/new/{itemFixName}")
    public ItemFix newItemFix(@PathVariable String itemFixName) {
        ItemFix newItemFix = new ItemFix();
        newItemFix.setItemFixName(itemFixName);

        return itemFixRepository.save(newItemFix);
    }
}
