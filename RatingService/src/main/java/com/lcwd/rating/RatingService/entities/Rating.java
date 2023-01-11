package com.lcwd.rating.RatingService.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Documented;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_rating")
public class Rating
{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
