package br.com.lasbr.adopetapi.dto;

import br.com.lasbr.adopetapi.entity.Shelter;

    public record ShelterResponse(
            Long id, String name, String phone, String email) {
        public ShelterResponse(Shelter shelter) {
            this(shelter.getId(), shelter.getName(), shelter.getPhone(), shelter.getEmail());
        }
    }
