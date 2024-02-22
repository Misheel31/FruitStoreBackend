package com.example.grocerystore.controller;

import com.example.grocerystore.dto.FruitItemDto;
import com.example.grocerystore.entity.FruitItem;
import com.example.grocerystore.service.FruitItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class FruitItemController {
    private final FruitItemService itemService;

    @GetMapping("/retrieve-item")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/save-item")
    public String createData(@RequestBody FruitItemDto itemDto) {
        itemService.save(itemDto);
        return "Data saved";
    }

    @GetMapping("/retrieve-all-item")
    public List<FruitItem> getAllData() {
        List<FruitItem> items = itemService.getAll();
        items.forEach(item -> item.setId(item.getId()));
        return items;
    }

    @GetMapping("/retrieve-item-by-id/{itemId}")
    public Optional<FruitItem> getById(@PathVariable("itemId") Integer itemId) {
        return itemService.getById(itemId);
    }

}
