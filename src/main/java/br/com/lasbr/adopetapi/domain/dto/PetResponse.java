package br.com.lasbr.adopetapi.domain.dto;

import br.com.lasbr.adopetapi.adapter.data.entities.Pet;
import br.com.lasbr.adopetapi.adapter.enums.PetType;

    public record PetResponse(
            Long id,
            PetType petType,
            String name,
            String breed,
            Integer age,
            String color,
            Float weight,
            Long shelterId,
            String shelterName) {

        public PetResponse(Pet pet) {
            this(pet.getId(), pet.getPetType(), pet.getName(), pet.getBreed(), pet.getAge(), pet.getColor(),
                    pet.getWeight(), pet.getShelter().getId(), pet.getShelter().getName());
        }
    }
