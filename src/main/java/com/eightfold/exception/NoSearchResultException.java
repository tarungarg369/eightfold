package com.eightfold.exception;

import org.springframework.http.HttpStatus;

public class NoSearchResultException {

  String message;
  HttpStatus code;


  public NoSearchResultException() {
  }

  public NoSearchResultException(String message, HttpStatus code) {
    this.message = message;
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getCode() {
    return code;
  }

  public void setCode(HttpStatus code) {
    this.code = code;
  }
}
