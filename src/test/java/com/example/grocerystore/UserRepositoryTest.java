package com.example.grocerystore;

import com.example.grocerystore.entity.User;
import com.example.grocerystore.repository.UserRepository;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUser() {

        User user = User.builder()
                .username("Hello")
                .email("abcd@gmail.com")
                .password("123456")
                .confirmPassword("123456")

                .build();
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getUserTest() {
        User user = userRepository.findById(1).get();
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void fetchAll() {
        List<User> user = userRepository.findAll();
        Assertions.assertThat(user.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void Update() {
        User user = userRepository.findById(1).get();
        user.setEmail("ab@gmail.com");
        User user1 = userRepository.save(user);
        Assertions.assertThat(user1.getUsername()).isEqualTo("ab@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void Delete(){
        User user=userRepository.findById(1).get();
        userRepository.delete(user);
        Optional<User> userOptional=userRepository.findById(1);
            User user1 = userOptional.orElse(null);
            Assertions.assertThat(user1).isNull();
    }

}
