package br.com.lasbr.adopetapi.repository;

import br.com.lasbr.adopetapi.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    }
