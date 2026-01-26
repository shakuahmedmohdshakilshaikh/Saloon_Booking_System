package com.shaku.salon_booking.Service;


import com.shaku.salon_booking.DTO.LoginRequest;
import com.shaku.salon_booking.DTO.RegisterRequest;
import com.shaku.salon_booking.Model.Role;
import com.shaku.salon_booking.Model.User;
import com.shaku.salon_booking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest request, Role role) {

        // Check if email already exists
        userRepository.findByEmail(request.email).ifPresent(u -> {
            throw new RuntimeException("Email already registered!");
        });

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setPhone(request.phone);
        user.setRole(role);
        user.setStatus("ACTIVE");

        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getStatus().equals("ACTIVE")) {
            throw new RuntimeException("User is blocked");
        }

        if (!user.getPassword().equals(request.password)) {
            throw new RuntimeException("Invalid password");
        }

        if (user.getRole() == Role.ADMIN) {
            return "ADMIN_LOGIN_SUCCESS";
        } else {
            return "USER_LOGIN_SUCCESS";
        }
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User blockUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus("BLOCKED");
        return userRepository.save(user);
    }
}

