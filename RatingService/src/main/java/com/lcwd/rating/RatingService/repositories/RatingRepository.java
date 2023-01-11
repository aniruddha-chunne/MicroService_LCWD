package com.lcwd.rating.RatingService.repositories;

import com.lcwd.rating.RatingService.entities.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String>
{

//        custom find method

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);


}
