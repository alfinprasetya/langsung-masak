package com.enigma.food.service.impl;

import com.enigma.food.model.Role;
import com.enigma.food.model.User;
import com.enigma.food.repository.UserRepository;
import com.enigma.food.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new RuntimeException("Username is already taken");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(Role.ROLE_ADMIN);
        return userRepository.save(request);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User Not Found")
                );
    }

    @Override
    public User update(Integer id, User request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new RuntimeException("Username is already taken");
        }
        User user = this.getOne(id);
        user.setUsername(request.getUsername());
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
