package br.com.lasbr.adopetapi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

    @Entity(name = "pets")
    @Table(name = "Pet")
    @Getter
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Pet {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Enumerated(EnumType.STRING)
        @NotNull
        private PetType petType;
        @NotBlank
        private String name;
        @NotBlank
        private String breed;
        @NotNull
        private Integer age;
        @NotBlank
        private String color;
        @NotNull
        private Float weight;
        @ManyToOne
        @JoinColumn(name = "shelter_id")
        private Shelter shelter;

    }
