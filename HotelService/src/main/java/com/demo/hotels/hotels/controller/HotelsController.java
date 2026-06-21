package com.demo.hotels.hotels.controller;

import com.demo.hotels.hotels.models.Hotels;
import com.demo.hotels.hotels.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    HotelService hotelService;
    public HotelsController(HotelService hotelService){
        this.hotelService=hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotels>createHotel(@RequestBody Hotels hotels){
        Hotels hotel=hotelService.createHotel(hotels);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotels>getHotelById(@PathVariable String hotelId){
        Hotels hotel=hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Hotels>>getAllHotels(){
        List<Hotels>hotels=hotelService.getAllHotels();
        return new ResponseEntity<>(hotels,HttpStatus.OK);
    }
}
