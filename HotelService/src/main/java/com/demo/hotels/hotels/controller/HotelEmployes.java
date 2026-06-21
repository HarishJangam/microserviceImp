package com.demo.hotels.hotels.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employes")
public class HotelEmployes {

    @GetMapping("/staff")
    public ResponseEntity<List>hotelStaff(){
        List<String> emp= Arrays.asList("ram","shyam","sid");
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
