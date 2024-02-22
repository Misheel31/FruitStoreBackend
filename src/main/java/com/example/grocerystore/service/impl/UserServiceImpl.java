package com.example.grocerystore.service.impl;

import com.example.grocerystore.config.PasswordEncoderUtil;
import com.example.grocerystore.dto.UserDto;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.repository.UserRepository;
import com.example.grocerystore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void register(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));
        user.setConfirmPassword(PasswordEncoderUtil.getInstance().encode(userDto.getConfirmPassword()));

//        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public boolean login(UserDto userDto) {
        return true;
    }

    @Override
    public List<UserDto> getAll(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getConfirmPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        return;
    }


    public UserDetails loadUserByUsername(String userEmail) {
        return this.loadUserByUsername(userEmail);
    }
}
