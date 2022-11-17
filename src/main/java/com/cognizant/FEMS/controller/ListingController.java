package com.cognizant.FEMS.controller;

import com.cognizant.FEMS.model.Listing;
import com.cognizant.FEMS.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/listing")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ListingController {

    @Autowired
    private final ListingService ls;

    @Autowired
    public ListingController(ListingService ls){
        this.ls = ls;
    }

    @GetMapping("/")
    public ResponseEntity<Listing> getById(@RequestParam int id){
        return new ResponseEntity<>(ls.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Listing>> getAll(){
        return new ResponseEntity<>(ls.getAll(),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Listing> update(@RequestBody Listing listing){
        return new ResponseEntity<>(ls.update(listing), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Listing> deleteListing(@RequestParam int id){
        return new ResponseEntity<>(ls.deleteListing(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/locationId")
    public ResponseEntity<List<Listing>> getByLocationId(int locationId){
        return new ResponseEntity<>(ls.getByLocationId(locationId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Listing> createListing(@RequestBody LinkedHashMap<String,String> body){
        return new ResponseEntity<>(ls.createListing(body), HttpStatus.ACCEPTED);
    }

}
