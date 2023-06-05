package com.GamingSetupShop.models.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO implements Serializable {
    @NotBlank(message = "Pleas enter your name!")
    private String customerName;
    @NotBlank(message = "Email must not be empty!")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Email is not valid")
    private String email;
    @NotNull(message = "The basket it can't be empty!")
    private List<String> selectedComponent;
    @NotNull
    private LocalDateTime orderDate;
    @Positive(message = "Must be a positive value!")
    private int totalPrice;
    @NotBlank(message = "Shipping address it can't be empty!")
    private String shippingAddress;
}
