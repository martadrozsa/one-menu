package com.denisczwicz.onemenu.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street cannot be blank")
    @Pattern(regexp = "[A-Za-zÀ-ÖØ-öø-ÿ\\s]+", message = "Invalid street format. Expected format: letters and spaces only")
    private String street;

    @NotBlank(message = "Number cannot be blank")
    @Pattern(regexp = "\\d+", message = "Invalid number format. Expected format: digits only")
    private String number;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid postal code format. Expected format: 00000-0000")
    private String postalCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
