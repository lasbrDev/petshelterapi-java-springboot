package br.com.lasbr.adopetapi.controller;

import br.com.lasbr.adopetapi.entity.Shelter;
import br.com.lasbr.adopetapi.repository.ShelterRepository;
import br.com.lasbr.adopetapi.service.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping({ "/shelters" })
    public class ShelterController {

        private ShelterService service;

        @GetMapping
        public ResponseEntity<List<Shelter>> list() {
            List<Shelter> shelters = service.shelterList();
            return ResponseEntity.ok(shelters);
        }

        @PostMapping
        public ResponseEntity<String> register(@RequestBody @Valid final Shelter shelter) {
            service.shleterRegister(shelter);
            return ResponseEntity.ok("Shelter registered successfully!");
        }
    }
