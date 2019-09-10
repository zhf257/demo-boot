package com.siukee.boot.advice;


public class AnotherExceptionErrorMessage {

  private final int status;
  private final String message;

  public AnotherExceptionErrorMessage(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
