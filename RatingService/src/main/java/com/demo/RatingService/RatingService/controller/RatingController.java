package com.demo.RatingService.RatingService.controller;

import com.demo.RatingService.RatingService.models.Rating;
import com.demo.RatingService.RatingService.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    RatingService ratingService;
    public RatingController(RatingService ratingService){
        this.ratingService=ratingService;
    }
    @PostMapping
    public ResponseEntity<Rating>createRating(@RequestBody Rating rating){
        Rating rating1=ratingService.createRating(rating);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Rating>>getAllRatings(){
        List<Rating>ratings=ratingService.getAllRatings();
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getAllRatingsByUserId(@PathVariable String userId){
        List<Rating>ratings=ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @PostMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getAllRatingsByHotelId(@PathVariable String hotelId){
        List<Rating>ratings=ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
}
