package com.demo.reviewservice;

public class RecordNotFoundException extends RuntimeException {

  public RecordNotFoundException(Throwable cause) {
    super(cause);
  }
}
