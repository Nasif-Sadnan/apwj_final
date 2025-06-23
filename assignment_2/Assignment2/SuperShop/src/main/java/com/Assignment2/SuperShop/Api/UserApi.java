package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.User;
import com.Assignment2.SuperShop.Service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserApi {
    private final UserService userSvc;

    public UserApi(UserService userSvc) {
        this.userSvc = userSvc;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userSvc.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userSvc.getById(id);
    }

    @GetMapping("/by-username/{username}")
    public User getByUsername(@PathVariable String username) {
        return userSvc.getByUsername(username);
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userSvc.register(user);
    }

}
