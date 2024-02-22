package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.FruitItemDto;
import com.example.grocerystore.entity.FruitItem;
import com.example.grocerystore.repository.FruitItemRepository;
import com.example.grocerystore.service.FruitItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FruitItemServiceImpl implements FruitItemService {
    private final FruitItemRepository itemRepository;

    @Override
    public String save(FruitItemDto itemDto) {
        FruitItem item = new FruitItem();

        if (itemDto.getItemId() != null) {
            item = itemRepository.findById(itemDto.getItemId())
                    .orElseThrow(() -> new NullPointerException("data not found"));
        }

        item.setName(itemDto.getItemName());
        item.setImage(itemDto.getImage());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setDescription(itemDto.getDescription());

        itemRepository.save(item);
        return "Data saved";
    }

    @Override
    public List<FruitItem> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<FruitItem> getById(Integer itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public void deleteById(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public void update(Integer itemId, FruitItemDto itemDto) {
        Optional<FruitItem> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            FruitItem existingItem = optionalItem.get();
            existingItem.setName(itemDto.getItemName());
            existingItem.setImage(itemDto.getImage());
            existingItem.setPrice(itemDto.getPrice());
            existingItem.setQuantity(itemDto.getQuantity());
            existingItem.setDescription(itemDto.getDescription());

            try {
                itemRepository.save(existingItem);
                System.out.println("Product updated successfully");
            } catch (Exception e) {
                System.err.println("Error updating product: " + e.getMessage());
                throw e;
            }
        }
    }

}

