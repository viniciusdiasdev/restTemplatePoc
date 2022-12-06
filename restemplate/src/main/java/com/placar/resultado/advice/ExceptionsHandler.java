package com.placar.resultado.advice;

import com.placar.resultado.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException){
        NotFoundException notFoundException1 = NotFoundException.builder().status(HttpStatus.NOT_FOUND.value()).devMessage("Cliente não encontrado.")
                .build();
        return new ResponseEntity<>(notFoundException, HttpStatus.NOT_FOUND);
    }
}
