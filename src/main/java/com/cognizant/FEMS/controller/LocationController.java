package com.cognizant.FEMS.controller;

import com.cognizant.FEMS.model.Location;
import com.cognizant.FEMS.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LocationController {

    @Autowired
    private final LocationService ks;

    @Autowired
    public LocationController(LocationService ks){
        this.ks = ks;
    }

    @GetMapping("/")
    public ResponseEntity<Location> getById(@RequestParam int id){
        return new ResponseEntity<>(ks.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAll(){
        return new ResponseEntity<>(ks.getAll(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Location> update(@RequestBody Location location){
        return new ResponseEntity<Location>(ks.update(location), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Location> deleteLocation(@RequestParam int id){
        return new ResponseEntity<>(ks.deleteLocation(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Location> createListing(@RequestBody LinkedHashMap<String, String> body){
        return new ResponseEntity<>(ks.createListing(body), HttpStatus.ACCEPTED);
    }

}
