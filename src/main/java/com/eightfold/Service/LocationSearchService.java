package com.eightfold.Service;

import com.eightfold.request.AddLocationRequest;
import com.eightfold.response.GenericResponse;
import com.eightfold.response.SearchResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface LocationSearchService {

   ResponseEntity<GenericResponse> addService(@RequestBody AddLocationRequest request);
   ResponseEntity<GenericResponse> deleteService(@RequestBody AddLocationRequest request);
   ResponseEntity<SearchResults> searchQueryService(String term);
}
