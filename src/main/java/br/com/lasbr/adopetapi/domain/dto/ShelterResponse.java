package br.com.lasbr.adopetapi.domain.dto;

import br.com.lasbr.adopetapi.adapter.data.entities.Shelter;

    public record ShelterResponse(
            Long id, String name, String phone, String email) {
        public ShelterResponse(Shelter shelter) {
            this(shelter.getId(), shelter.getName(), shelter.getPhone(), shelter.getEmail());
        }
    }
