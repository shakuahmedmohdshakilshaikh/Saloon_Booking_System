package com.shaku.salon_booking.DTO;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank(message = "Name cannot be empty")
    public String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    public String email;

    @NotBlank(message = "Password cannot be empty")
    public String password;

    @NotBlank(message = "Phone cannot be empty")
    public String phone;
}

