package com.shaku.salon_booking.Controller;


import com.shaku.salon_booking.DTO.LoginRequest;
import com.shaku.salon_booking.DTO.RegisterRequest;
import com.shaku.salon_booking.Model.Role;
import com.shaku.salon_booking.Model.User;
import com.shaku.salon_booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request, Role.CUSTOMER);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }

    @PostMapping("/register-admin")
    public User registerAdmin(@RequestBody RegisterRequest request) {
        return userService.registerUser(request, Role.ADMIN);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @PutMapping("/block/{userId}")
    public ResponseEntity<User> blockUser(@PathVariable Long userId) {
        User blockedUser = userService.blockUser(userId);
        return ResponseEntity.ok(blockedUser);
    }

}

