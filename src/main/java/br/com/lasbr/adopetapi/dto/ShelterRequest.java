package br.com.lasbr.adopetapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

    public record ShelterRequest(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String phone,
        @NotBlank
        @Email
        String email,
        List<Long> petIds) {
    }
