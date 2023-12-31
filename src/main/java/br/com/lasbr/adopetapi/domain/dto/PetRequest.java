package br.com.lasbr.adopetapi.domain.dto;

import br.com.lasbr.adopetapi.adapter.enums.PetType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

    public record PetRequest(

            @NotNull
            @Enumerated(EnumType.STRING)
            PetType petType,
            @NotBlank
            String name,
            @NotBlank
            String breed,
            @NotNull
            Integer age,
            @NotBlank
            String color,
            @NotNull
            Float weight,
            @NotNull
            Long shelterId) {
    }
