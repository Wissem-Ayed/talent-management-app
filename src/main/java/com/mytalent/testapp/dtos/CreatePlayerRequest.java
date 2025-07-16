package com.mytalent.testapp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mytalent.testapp.entities.Position;
import com.mytalent.testapp.entities.PreferredFoot;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePlayerRequest {

    @NotBlank(message = "First Name is required")
    @Size(min = 1, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(min = 1, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^[+]?[0-9\\s\\-()]{8,20}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Size(max = 50, message = "Nationality cannot exceed 50 characters")
    private String nationality;

    @Size(max = 200, message = "Address line cannot exceed 200 characters")
    private String addressLine2;

    @Size(max = 100, message = "City cannot exceed 100 characters")
    private String city;

    @Size(max = 100, message = "State cannot exceed 100 characters")
    private String state;

    @NotNull(message = "Primary position is required")
    private Position primaryPosition;

    private Position secondaryPosition;

    @NotNull(message = "Preferred foot is required")
    private PreferredFoot preferredFoot;

    @Min(value = 0, message = "Height must be positive")
    @Max(value = 250, message = "Height cannot exceed 250 cm")
    private int heightInCm;

    @Min(value = 0, message = "Weight must be positive")
    @Max(value = 200, message = "Weight cannot exceed 200 kg")
    private int weightInKg;

    @Size(max = 500, message = "Profile photo URL cannot exceed 500 characters")
    private String profilePhotoUrl;

    @Size(max = 500, message = "Certificate of birth URL cannot exceed 500 characters")
    private String certificateOfBirthUrl;

}