package com.demo.reviewservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<String> recordNotFoundException() {

    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Record with id 2 not found");

    return ResponseEntity.of(problemDetail).build();
  }
}
