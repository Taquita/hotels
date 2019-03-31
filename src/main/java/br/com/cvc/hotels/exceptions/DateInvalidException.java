package br.com.cvc.hotels.exceptions;

import org.springframework.http.HttpStatus;

public class DateInvalidException extends CommonException{

    public DateInvalidException(String s) {
        super(s, "DateInvalidException");
    }

    public DateInvalidException(String s, HttpStatus code) {
        super(s, "DateInvalidException", code);
    }

    public DateInvalidException(String s, HttpStatus code, Throwable throwable) {
        super(s, "DateInvalidException", code, throwable);
    }
}
