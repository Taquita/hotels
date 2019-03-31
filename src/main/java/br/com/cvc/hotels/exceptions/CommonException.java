package br.com.cvc.hotels.exceptions;

import org.springframework.http.HttpStatus;

public abstract class CommonException extends RuntimeException {

    private final HttpStatus code;
    private final String exception;

    public CommonException(String s, String exception) {
        super(s);
        this.exception = exception;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CommonException(String s, String exception, HttpStatus code) {
        super(s);
        this.exception = exception;
        this.code = code;
    }

    public CommonException(String s, String exception, HttpStatus code, Throwable throwable) {
        super(s, throwable);
        this.code = code;
        this.exception = exception;
    }

    public HttpStatus getCode() {
        return code;
    }

    public int getStatus() {
        return code.value();
    }

    public String getError() {
        return code.name();
    }

    public String getException() {
        return exception;
    }
}
