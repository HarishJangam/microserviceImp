package com.demo.RatingService.RatingService.service;

import com.demo.RatingService.RatingService.models.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating>getAllRatings();
    List<Rating>getRatingByUserId(String userId);
    List<Rating>getRatingByHotelId(String hotelId);
}
