package com.eightfold.controller;
import com.eightfold.Service.LocationSearchService;
import com.eightfold.Service.Trie;
import com.eightfold.request.AddLocationRequest;
import com.eightfold.response.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class LocationSearchController {


  @Autowired
  private LocationSearchService locationSearchService;


  @RequestMapping(value= "/add" ,  method = RequestMethod.POST)
  public String addLocation(@RequestBody AddLocationRequest request) {
     locationSearchService.addService(request);
     return null;


  }


  @RequestMapping(value= "/delete" ,  method = RequestMethod.POST)
  public String deleteLocation(@RequestBody AddLocationRequest request) {
    locationSearchService.deleteService(request);
    return null;
  }

  @RequestMapping(value= "/query" ,  method = RequestMethod.GET)
  public @ResponseBody
  ResponseEntity<SearchResults> queryLocations(@RequestParam("term") String term) {
    return locationSearchService.searchQueryService(term);

   // locationSearchService.searchQueryService();

  }
}
