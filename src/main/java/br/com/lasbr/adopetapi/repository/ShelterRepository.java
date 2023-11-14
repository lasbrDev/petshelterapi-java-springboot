package br.com.lasbr.adopetapi.repository;

import br.com.lasbr.adopetapi.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ShelterRepository extends JpaRepository<Shelter, Long> {
        boolean existsByName(final String name);

        boolean existsByPhone(final String phone);

        boolean existsByEmail(final String email);

        Shelter findByName(final String name);
    }
