package com.example.gestionfoyer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etudiant")
public class EtudinatController {

    @GetMapping
    ResponseEntity<String> hello (){
        return ResponseEntity.ok("working");
    }
}
