package br.com.lasbr.adopetapi.controller;

import br.com.lasbr.adopetapi.entity.Pet;
import br.com.lasbr.adopetapi.service.PertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping({"/pets" })
    public class PetController {

        @Autowired
        private PertService service;

        @GetMapping("/{idOrName}")
        public ResponseEntity<List<Pet>> petList(@PathVariable final String idOrName) {
            List<Pet> pets = service.petList(idOrName);
            return ResponseEntity.ok(pets);
        }
    }
