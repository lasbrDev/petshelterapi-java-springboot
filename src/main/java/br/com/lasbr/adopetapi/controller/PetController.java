package br.com.lasbr.adopetapi.controller;

import br.com.lasbr.adopetapi.entity.Pet;
import br.com.lasbr.adopetapi.service.PertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping({"/pets" })
    public class PetController {

        @Autowired
        private PertService service;

        @GetMapping("/{idOrName}")
        public ResponseEntity<List<Pet>> petList(@PathVariable final String idOrName) {
            List<Pet> pets = service.getPetsByShelter(idOrName);
            return ResponseEntity.ok(pets);
        }

        @PostMapping({ "/{idOrName}/pets" })
        public ResponseEntity<String> registerPet(
                @PathVariable final String idOrName, @RequestBody @Valid final Pet pet) {
            service.registerPet(Long.parseLong(idOrName), pet);
            return ResponseEntity.ok("Pet registered successfully!");
        }
    }
