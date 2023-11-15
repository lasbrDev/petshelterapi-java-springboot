package br.com.lasbr.adopetapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


    @Entity(name = "shelters")
    @Table(name = "Shelter")
    @Data
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Shelter {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String phone;
        private String email;
        @OneToMany(mappedBy = "shelter", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
        @JsonManagedReference
        private List<Pet> pets;

        public Shelter() {
            this.pets = new ArrayList<>();
        }
    }
