package br.com.cvc.hotels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class responsible for catching errors and performing the treatments
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommonException.class)
    protected ResponseEntity<ErrorAPI> exceptionHandler(CommonException ex) {
        ErrorAPI error = new ErrorAPI(ex.getStatus(), ex.getError(), ex.getException(), ex.getMessage());
        return new ResponseEntity<>(error, ex.getCode());
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorAPI> exceptionHandler(RuntimeException ex) {
        ErrorAPI error = new ErrorAPI(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorAPI> exceptionHandler(Exception ex) {
        ErrorAPI error = new ErrorAPI(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
