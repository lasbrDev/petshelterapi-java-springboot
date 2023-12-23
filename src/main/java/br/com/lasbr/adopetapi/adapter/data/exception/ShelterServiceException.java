package br.com.lasbr.adopetapi.adapter.data.exception;

    public class ShelterServiceException extends RuntimeException {

        public ShelterServiceException(String message) {
            super(message);
        }

        public ShelterServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
