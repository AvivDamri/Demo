package com.example.demo.advice;


import com.example.demo.exception.InvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@RestController
public class ControllerAdviceImpl {

    @ExceptionHandler(value = {InvalidException.class})
    public ResponseEntity<?> handle(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}
