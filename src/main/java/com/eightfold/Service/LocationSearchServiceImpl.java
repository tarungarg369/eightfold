package com.eightfold.Service;

import com.eightfold.request.AddLocationRequest;
import com.eightfold.response.GenericResponse;
import com.eightfold.response.SearchResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class LocationSearchServiceImpl implements LocationSearchService {

  private static Trie searchTree;
  private Map<String , Long> insertedKeys = new HashMap<>();

  static  {
    searchTree = new Trie();
  }


  @Override
  public ResponseEntity<GenericResponse> addService(@RequestBody AddLocationRequest request) {
    GenericResponse response = new GenericResponse();
    searchTree.insert(request.getLocation());
    insertedKeys.put(request.getLocation(),request.getPopularity());
    response.setMessage("inserted succesfully");
    response.setCode(HttpStatus.OK);
    return new ResponseEntity<>(response ,HttpStatus.OK);

  }

  @Override
  public ResponseEntity<GenericResponse> deleteService(@RequestBody AddLocationRequest request) {
    return new ResponseEntity<>(new GenericResponse() ,HttpStatus.OK);
  }

  @Override
  public ResponseEntity<SearchResults> searchQueryService(String term) {
      List<String> results =  searchTree.searchPrefix(term);
    TreeMap<String , Long> sortedMap = new TreeMap<>();
   /*   for(String searchResult : results) {

      }*/
      SearchResults searchResults = new SearchResults(" results fetched successfull " , HttpStatus.OK ,  results);
    return new ResponseEntity<>(searchResults , HttpStatus.OK);

  }
}
