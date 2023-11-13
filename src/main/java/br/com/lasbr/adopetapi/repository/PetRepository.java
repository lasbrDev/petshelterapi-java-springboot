package br.com.lasbr.adopetapi.repository;

import br.com.lasbr.adopetapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface PetRepository extends JpaRepository<Pet, Long> {
        Optional<Pet> findByName(String idOrName);
    }
