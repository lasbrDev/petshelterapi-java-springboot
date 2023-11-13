package br.com.lasbr.adopetapi.service;

import br.com.lasbr.adopetapi.entity.Pet;
import br.com.lasbr.adopetapi.repository.PetRepository;
import br.com.lasbr.adopetapi.service.exception.PetNotfoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class PertService {

        private final PetRepository repository;
        public List<Pet> petList(String idOrName) {
            try {
                Long id = Long.parseLong(idOrName);
                return repository.findById(id).orElseThrow(EntityNotFoundException::new).getPets();
            } catch (EntityNotFoundException enfe) {
                log.error("Pet not found: {}", enfe.getMessage());
                throw new PetNotfoundException("Pet not found.");
            } catch (NumberFormatException e) {
                try {
                    return repository.findByName(idOrName).orElseThrow(EntityNotFoundException::new).getPets();
                } catch (EntityNotFoundException enfe2) {
                    log.error("Pet not found: {}", enfe2.getMessage());
                    throw new PetNotfoundException("Pet not found.");
                }
            }
        }
    }
