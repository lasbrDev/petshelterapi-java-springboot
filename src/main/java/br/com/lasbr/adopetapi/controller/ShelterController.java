package br.com.lasbr.adopetapi.controller;

import br.com.lasbr.adopetapi.entity.Shelter;
import br.com.lasbr.adopetapi.repository.ShelterRepository;
import br.com.lasbr.adopetapi.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping({ "/shelters" })
    public class ShelterController {

        private ShelterService service;

        public ResponseEntity<List<Shelter>> list() {
            return ResponseEntity.ok(service.shelterList());
        }
    }
