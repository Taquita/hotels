package br.com.cvc.hotels.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for common properties for exceptions
 */
abstract class CommonException extends RuntimeException {

    private final HttpStatus code;
    private final String exception;

    CommonException(String s, String exception) {
        super(s);
        this.exception = exception;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    CommonException(String s, String exception, HttpStatus code) {
        super(s);
        this.exception = exception;
        this.code = code;
    }

    CommonException(String s, String exception, HttpStatus code, Throwable throwable) {
        super(s, throwable);
        this.code = code;
        this.exception = exception;
    }

    HttpStatus getCode() {
        return code;
    }

    int getStatus() {
        return code.value();
    }

    String getError() {
        return code.name();
    }

    String getException() {
        return exception;
    }
}
