package br.com.cvc.hotels.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class ErrorAPI {

    private int status;
    private String error;
    private String exception;
    private String message;

    public ErrorAPI(String message) {
        this.message = message;
        this.status = 500;
        this.error= "BAD REQUEST";
    }

}
