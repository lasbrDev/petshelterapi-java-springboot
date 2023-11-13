package br.com.lasbr.adopetapi.service.exception;

    public class ShelterServiceException extends RuntimeException {

        public ShelterServiceException(String message) {
            super(message);
        }

        public ShelterServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
