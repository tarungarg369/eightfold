package com.eightfold.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class SearchResults extends GenericResponse{

  private List<String>  terms ;

  public SearchResults(String message, HttpStatus code, List<String> terms) {
    super(message, code);
    this.terms = terms;
  }

  public List<String> getTerms() {
    return terms;
  }

  public void setTerms(List<String> terms) {
    this.terms = terms;
  }
}
