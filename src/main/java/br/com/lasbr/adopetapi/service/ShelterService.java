package br.com.lasbr.adopetapi.service;

import br.com.lasbr.adopetapi.entity.Shelter;
import br.com.lasbr.adopetapi.repository.ShelterRepository;
import br.com.lasbr.adopetapi.service.exception.ShelterServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
                log.error("Erro ao listar abrigos.", e);
                throw new ShelterServiceException("Error listing shelters.", e);
            }

        }
    }
