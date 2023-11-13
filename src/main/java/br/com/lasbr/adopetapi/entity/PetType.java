package br.com.lasbr.adopetapi.entity;

import jakarta.persistence.EnumType;

    public enum PetType {

        GATO, CACHORRO;
        
        private static /* synthetic */ PetType[] $values() {
            return new PetType[] { PetType.GATO, PetType.CACHORRO };
        }
    }

