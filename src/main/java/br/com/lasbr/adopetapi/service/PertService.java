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
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class PertService {

        private final PetRepository petRepository;
        private final ShelterRepository shelterRepository;

        public List<Pet> getPetsByShelter(String idOrName) {
            Shelter shelter = getShelter(Long.valueOf(idOrName));
            log.info("List of pets in shelter {} successfully retrieved.", shelter.getName());
            return shelter.getPets();
        }

        private Shelter getShelter(String idOrName) {
            try {
                Long id = Long.parseLong(idOrName);
                return shelterRepository.getReferenceById(id);
            } catch (EntityNotFoundException | NumberFormatException e) {
                Shelter shelter = shelterRepository.findByName(String.valueOf(idOrName));
                if (shelter == null) {
                    throw new ShelterServiceException("Shelter not found!");
                }
                return shelter;
            }
        }
        @Transactional
        public void registerPet(Long idOrName, Pet pet) {
            Shelter shelter = getShelter(idOrName);
            pet.setShelter(shelter);
            shelter.getPets().add(pet);
            shelterRepository.save(shelter);
            log.info("Pet {} successfully registered in shelter {}.", pet.getName(), shelter.getName());
        }
        private Shelter getShelter(Long idOrName) {
            try {
                Long id = Long.parseLong(String.valueOf(idOrName));
                Shelter shelter = shelterRepository.getReferenceById(idOrName);
                log.debug("Shelter found by ID: {}", shelter.getName());
                return shelter;
            } catch (EntityNotFoundException | NumberFormatException e) {
                Shelter shelter = shelterRepository.findByName(String.valueOf(idOrName));
                if (shelter == null) {
                    log.error("Shelter not found by ID or name: {}", idOrName);
                    throw new ShelterServiceException("Shelter not found.");
                }
                log.debug("Shelter found by name: {}", shelter.getName());
                return shelter;
            }
        }
    }
