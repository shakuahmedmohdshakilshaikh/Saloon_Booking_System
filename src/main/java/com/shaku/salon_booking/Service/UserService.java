package com.shaku.salon_booking.Service;





import com.shaku.salon_booking.DTO.LoginRequest;
import com.shaku.salon_booking.DTO.RegisterRequest;
import com.shaku.salon_booking.Model.Role;
import com.shaku.salon_booking.Model.User;

import java.util.List;

public interface UserService {

    User registerUser(RegisterRequest request, Role role);

    String loginUser(LoginRequest request);

    List<User> getAllUsers();

    User blockUser(Long userId);
}
