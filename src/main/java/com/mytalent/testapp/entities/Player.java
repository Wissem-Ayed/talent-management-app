package com.mytalent.testapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 100)
    @NotBlank(message = "First Name is required")
    @Size(min = 1, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Last Name is required")
    @Size(min = 1, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(length = 20)
    @Pattern(regexp = "^[+]?[0-9\\s\\-()]{8,20}$", message = "Invalid phone number format")
    private String phoneNumber;

    @Column(nullable = false)
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Column(length = 50)
    @Size(max = 50, message = "Nationality cannot exceed 50 characters")
    private String nationality;

    @Column(length = 200)
    @Size(max = 200, message = "Address line cannot exceed 200 characters")
    private String addressLine2;

    @Column(length = 100)
    @Size(max = 100, message = "City cannot exceed 100 characters")
    private String city;

    @Column(length = 100)
    @Size(max = 100, message = "State cannot exceed 100 characters")
    private String state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Primary position is required")
    private Position primaryPosition;

    @Enumerated(EnumType.STRING)
    private Position secondaryPosition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Primary position is required")
    private PreferredFoot preferredFoot;

    @Column(nullable = false)
    @Min(value = 0, message = "Height must be positive")
    @Max(value = 250, message = "Height cannot exceed 250 cm")
    private int heightInCm;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", message = "Weight must be positive")
    @DecimalMax(value = "200.0", message = "Weight cannot exceed 250 kg")
    private int weightInKg;

    @Column(length = 500)
    @Size(max = 500, message = "Profile photo URL cannot exceed 500 characters")
    private String profilePhotoUrl;

    @Column(length = 500)
    @Size(max = 500, message = "Profile photo URL cannot exceed 500 characters")
    private String certificateOfBirthUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Integer getAge() {
        if (dateOfBirth != null) {
            return LocalDate.now().getYear() - dateOfBirth.getYear();
        }
        return null;
    }

}
