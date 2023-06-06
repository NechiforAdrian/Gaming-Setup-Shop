package com.GamingSetupShop.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    @NotBlank(message = "First name must not be empty field!")
    @Size(min = 3, max = 32, message = "Your first name must have between 3 and 32 characters")
    private String customerFirstName;
    @NotBlank(message = "Last name must not be empty field!")
    @Size(min = 3, max = 32, message = "Your last name must have between 3 and 32 characters")
    private String customerLastName;
    @NotBlank(message = "Email must not be empty field!")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Email is not valid")
    private String email;
    @NotBlank(message = "Phone number must not be empty field!")
    @Size(min = 10, max = 15, message = "Minimum of 10 numbers, Maximum 15 numbers!")
    private String phoneNumber;
    @NotBlank(message = "Address must not be empty!")
    private String address;

}
