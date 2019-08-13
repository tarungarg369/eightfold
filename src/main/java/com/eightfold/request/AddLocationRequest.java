package com.eightfold.request;

public class AddLocationRequest {

  String location;
  Long popularity;

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Long getPopularity() {
    return popularity;
  }

  public void setPopularity(Long popularity) {
    this.popularity = popularity;
  }
}
