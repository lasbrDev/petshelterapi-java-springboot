package br.com.lasbr.adopetapi.service.exception;

    public class PetNotfoundException extends RuntimeException {
        public PetNotfoundException(String message) {
            super(message);
        }

        public PetNotfoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
