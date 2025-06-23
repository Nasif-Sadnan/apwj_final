package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.User;
import com.Assignment2.SuperShop.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return userRepo.getAll();
    }

    public User getById(int id) {
        return userRepo.getById(id);
    }

    public User getByUsername(String username) {
        return userRepo.getByUsername(username);
    }

    public void register(User user) {
        userRepo.save(user);
    }
}
