package com.example.grocerystore;
import com.example.grocerystore.entity.FruitItem;
import com.example.grocerystore.repository.FruitItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepositoryTest {
    @Autowired
    private FruitItemRepository itemRepository;
    @Test
    @Order(1)
    @Rollback(value = false)

    public void saveItem() {
        FruitItem item= new FruitItem();
        item.setDescription("Testing Description");
        item.setName("Name");
        item.setPrice("1200");
        item.setImage("image");
        item = itemRepository.save(item);
        Assertions.assertThat(item.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<FruitItem> item = Optional.of(itemRepository.findById(1).get());
        Assertions.assertThat(item.get().getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAll(){
        List<FruitItem> itemList = itemRepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        FruitItem item =itemRepository.findById(1).get();
        item.setName("Item Name");
        itemRepository.save(item);

        Assertions.assertThat(item.getName()).isEqualTo("Item Name");
    }

    @Test
    @Order(5)
    public void deleteById(){
        itemRepository.deleteById(1);
        FruitItem item1 =null;
        Optional<FruitItem> item= itemRepository.findById(1);

        if(item.isPresent()){
            item1=item.get();
        }

        Assertions.assertThat(item1).isNull();
    }


}
