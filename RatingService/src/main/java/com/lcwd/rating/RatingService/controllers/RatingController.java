package com.lcwd.rating.RatingService.controllers;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.services.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController
{
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        System.out.println("Create Rating");
        Rating ratingone =  ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingone);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingsByHoteId(hotelId));
    }


    @GetMapping
    public ResponseEntity<List<Rating>>getRating()
    {
        return ResponseEntity.ok(ratingService.getRatings());
    }


}
