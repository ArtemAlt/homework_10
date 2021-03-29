package ru.education.homework_10.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchProductException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new AwesomeException("There is no such product"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoValuesInResponse.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoValuesInResponse() {
        return new ResponseEntity<>(new AwesomeException("There is no values for such request"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidToken.class)
    protected ResponseEntity<AwesomeException> handleInvalidToken() {
        return new ResponseEntity<>(new AwesomeException("Invalid token"), HttpStatus.UNAUTHORIZED);
    }


    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }
}