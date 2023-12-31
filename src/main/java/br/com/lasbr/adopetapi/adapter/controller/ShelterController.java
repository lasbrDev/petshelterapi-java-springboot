package br.com.lasbr.adopetapi.adapter.controller;

import br.com.lasbr.adopetapi.domain.dto.ShelterRequest;
import br.com.lasbr.adopetapi.domain.dto.ShelterResponse;
import br.com.lasbr.adopetapi.domain.service.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping({ "/shelters" })
    public class ShelterController {

        @Autowired
        private ShelterService service;

        @GetMapping
        public ResponseEntity<List<ShelterResponse>> list() {
            List<ShelterResponse> shelters = service.responses();
            return ResponseEntity.ok(shelters);
        }

        @PostMapping
        public ResponseEntity<String> register(@RequestBody @Valid final ShelterRequest request) {
            service.shleterRegister(request);
            return ResponseEntity.ok("Shelter registered successfully!");
        }
    }
