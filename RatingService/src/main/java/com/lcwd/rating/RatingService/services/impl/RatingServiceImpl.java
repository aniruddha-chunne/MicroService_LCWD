package com.lcwd.rating.RatingService.services.impl;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repositories.RatingRepository;
import com.lcwd.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepository repository;
    @Override
    public Rating create(Rating rating) {

        String randomRatingId   = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHoteId(String hotelId)
    {
        return repository.findByHotelId(hotelId);
    }
}
