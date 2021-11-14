package com.inventory.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@ControllerAdvice
public class GlobalInventoryException extends ResponseEntityExceptionHandler {
    Logger myLogger = Logger.getLogger(String.valueOf(InventoryException.class));

    public ResponseEntity<Object> globalInventoryException(InventoryException myInventoryException, WebRequest myRequest){
        Map<String, Object> body = new HashMap<>();
        body.put("time-stamp: ", LocalDateTime.now());
        body.put("message", "Inventory Error Occurred!");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}


