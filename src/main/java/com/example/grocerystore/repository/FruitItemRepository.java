package com.example.grocerystore.repository;

import com.example.grocerystore.entity.FruitItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitItemRepository extends JpaRepository<FruitItem, Integer> {
}
