package br.com.lasbr.adopetapi.entity;


import jakarta.persistence.*;
import lombok.*;

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
        private PetType type;
        private String name;
        private String breed;
        private Integer age;
        private String color;
        private Float weight;
    }
