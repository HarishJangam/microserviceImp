package com.demo.RatingService.RatingService.service;

import com.demo.RatingService.RatingService.models.Rating;
import com.demo.RatingService.RatingService.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImp implements RatingService{
    RatingRepository ratingRepository;
    public RatingServiceImp(RatingRepository ratingRepository){
        this.ratingRepository=ratingRepository;
    }
    @Override
    public Rating createRating(Rating rating) {
        String id= UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating>ratings=ratingRepository.findAll();
        return ratings;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
