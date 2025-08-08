package com.bcss.shopall.controller;

import com.bcss.shopall.exceptions.DatosNoValidosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerAdvice {

    @ExceptionHandler(DatosNoValidosException.class)
    public ResponseEntity<?> validacionEntradaDatos(DatosNoValidosException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error)->{errors.put(error.getField(),error.getDefaultMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
