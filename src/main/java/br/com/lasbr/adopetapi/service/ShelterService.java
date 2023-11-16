package br.com.lasbr.adopetapi.service;

import br.com.lasbr.adopetapi.dto.ShelterRequest;
import br.com.lasbr.adopetapi.entity.Shelter;
import br.com.lasbr.adopetapi.repository.ShelterRepository;
import br.com.lasbr.adopetapi.service.exception.ShelterServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class ShelterService {

        private final ShelterRepository repository;

        public List<Shelter> shelterList() {
            try {
                List<Shelter> shelters = repository.findAll();
                log.info("List of shelters successfully recovered. Total shelters: ", shelters.size());
                return shelters;
            } catch (Exception e) {
                log.error("Error listing shelters.", e);
                throw new ShelterServiceException("Error listing shelters.", e);
            }
        }

        @Transactional
        public void shleterRegister(ShelterRequest request) {
            boolean nameAlreadyRegistered = repository.existsByName(request.name());
            boolean phoneAlreadyRegistered = repository.existsByPhone(request.phone());
            boolean emailAlreadyRegistered = repository.existsByEmail(request.email());

            if (nameAlreadyRegistered || phoneAlreadyRegistered || emailAlreadyRegistered) {
                throw new ShelterServiceException("Data already registered for another shelter!");
            }

            try {
                Shelter shelter = new Shelter();
                shelter.setName(request.name());
                shelter.setPhone(request.phone());
                shelter.setEmail(request.email());
                repository.save(shelter);
                log.info("Shelter {} successfully registered.", request.name());
            } catch (Exception e) {
                log.error("Error during shelter registration: {}", e.getMessage());
                throw new ShelterServiceException("Error during shelter registration.");
            }
        }
    }
