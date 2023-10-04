package com.likelion.springstudy.global;


import jakarta.persistence.EntityExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Void> handleEntityExistsException(EntityExistsException e) {
        return ResponseEntity.notFound().build();
    }

}
