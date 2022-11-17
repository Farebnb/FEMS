package com.cognizant.FEMS.controller;

import com.cognizant.FEMS.model.User;
import com.cognizant.FEMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody LinkedHashMap<String, String> body){
        return ResponseEntity.ok(us.register(body));
    }

    @GetMapping("/username")
    public ResponseEntity<User> viewByUsername(@RequestParam String username) {
        return ResponseEntity.ok(us.getByUsername(username));
    }

    @GetMapping("/")
    public ResponseEntity<User> viewByUserId(@RequestParam int id) {
        return ResponseEntity.ok(us.getById(id));
    }

    @GetMapping("/listingId")
    public ResponseEntity<User> viewByListingId(@RequestParam int listingId) {
        return ResponseEntity.ok(us.getByListingId(listingId));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> viewAllUsers() {
        return ResponseEntity.ok(us.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User u) {
        return ResponseEntity.ok(us.update(u));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(@RequestParam int id) {
        return ResponseEntity.ok(us.delete(id));
    }

}
