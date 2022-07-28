package com.example.forum.Exceptions.Handlers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.forum.exchanges.DefaultResponseFormat;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {


    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.toList());

    DefaultResponseFormat nbException = new DefaultResponseFormat(400, "Error while processing your order", errors);

    return new ResponseEntity<>(nbException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
    List<String> errors = new ArrayList<>();

    ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));


    DefaultResponseFormat nbException = new DefaultResponseFormat(400, "Error while processing your order", errors);

    return new ResponseEntity<>(nbException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<DefaultResponseFormat> genericHandler(Exception ex, WebRequest request) {
    List<String> errors = new ArrayList<>();

    errors.add(ex.getMessage()) ;
    DefaultResponseFormat nbException = new DefaultResponseFormat(400, "Error while processing your order", errors);
    return new ResponseEntity<DefaultResponseFormat>(nbException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> runtimeExceptionHandler(RuntimeException ex, WebRequest request) {
    List<String> errors = new ArrayList<>();

    errors.add(ex.getMessage()) ;
    Map<String,Object> response = new HashMap<>() ;
    response.put("errors", errors) ;
    
    DefaultResponseFormat nbException = new DefaultResponseFormat(400, "Error while processing your order", errors);
    return new ResponseEntity<>(nbException, HttpStatus.BAD_REQUEST);
  }
}