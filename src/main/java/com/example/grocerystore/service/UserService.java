package com.example.grocerystore.service;

import com.example.grocerystore.dto.UserDto;
import com.example.grocerystore.entity.User;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);

    boolean login(UserDto userDto);

    List<UserDto> getAll();

    User getCurrentUser();

    void deleteUser(Integer userId);
}
