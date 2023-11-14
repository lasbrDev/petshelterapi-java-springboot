package br.com.lasbr.adopetapi.service;

import br.com.lasbr.adopetapi.entity.Pet;
import br.com.lasbr.adopetapi.entity.Shelter;
import br.com.lasbr.adopetapi.repository.PetRepository;
import br.com.lasbr.adopetapi.repository.ShelterRepository;
import br.com.lasbr.adopetapi.service.exception.PetNotfoundException;
import br.com.lasbr.adopetapi.service.exception.ShelterServiceException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class PertService {

        private final PetRepository petRepository;
        private final ShelterRepository shelterRepository;

        public List<Pet> petList(String idOrName) {
            try {
                Long id = Long.parseLong(idOrName);
                return petRepository.findById(id).orElseThrow(EntityNotFoundException::new).getPets();
            } catch (EntityNotFoundException enfe) {
                log.error("Pet not found: {}", enfe.getMessage());
                throw new PetNotfoundException("Pet not found.");
            } catch (NumberFormatException e) {
                try {
                    return petRepository.findByName(idOrName).orElseThrow(EntityNotFoundException::new).getPets();
                } catch (EntityNotFoundException enfe2) {
                    log.error("Pet not found: {}", enfe2.getMessage());
                    throw new PetNotfoundException("Pet not found.");
                }
            }
        }

        public void registerPet(Long idOrName, Pet pet) {
            Shelter shelter = getShelter(idOrName);
            pet.setShelter(shelter);
            shelter.getPets().add(pet);
            shelterRepository.save(shelter);
        }
        private Shelter getShelter(Long idOrName) {
            try {
                Long id = Long.parseLong(String.valueOf(idOrName));
                return shelterRepository.getReferenceById(id);
            } catch (EntityNotFoundException | NumberFormatException e) {
                Shelter shelter = shelterRepository.findByName(String.valueOf(idOrName));
                if (shelter == null) {
                    throw new ShelterServiceException("Shelter not found.");
                }
                return shelter;
            }
        }
    }
