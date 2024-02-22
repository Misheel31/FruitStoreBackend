package com.example.grocerystore.service;

import com.example.grocerystore.dto.FruitItemDto;
import com.example.grocerystore.entity.FruitItem;

import java.util.List;
import java.util.Optional;

public interface FruitItemService {
    String save(FruitItemDto itemDto);

    List<FruitItem> getAll();

    Optional<FruitItem> getById(Integer itemId);

    void deleteById(Integer itemId);

    void update(Integer itemId, FruitItemDto itemDto);
}
