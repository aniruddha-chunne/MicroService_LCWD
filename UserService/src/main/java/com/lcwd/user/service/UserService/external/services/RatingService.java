package com.lcwd.user.service.UserService.external.services;


import com.lcwd.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;
import java.util.Objects;

@FeignClient(name="RATING-SERVICE")
public interface RatingService
{
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable ("ratingId")String ratingId);


}
