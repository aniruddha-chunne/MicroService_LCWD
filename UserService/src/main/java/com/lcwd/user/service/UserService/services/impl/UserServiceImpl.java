package com.lcwd.user.service.UserService.services.impl;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user)
    {
        String randomUserId   = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId)
    {
        User user  = userRepository.findById(userId).orElseThrow(() ->  new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
           // fetch rating of the above use r from Rating Service
          //http://localhost:8083/ratings/users/d5c38653-e157-499d-9d5e-388e6ce27b45
            Rating[] ratingsOfUser  = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), Rating[].class);
            logger.info(" {} ", ratingsOfUser);


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        ratingsOfUser.toString();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

//            user.setRatings(ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
            List<Rating> ratingList = ratings.stream().map(rating ->

                            {
                                //api call to hotel service to get the hotel
                                //set the hotel to ratings
                                //return the ratings
                                //http://localhost:8082/hotels/df806d5b-675a-442e-8dee-2ad44e8c9

                                System.out.println(rating.getHotelId());

                               ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);

                               if(forEntity.getBody()==null)
                               {
                                   return null;
                               }
                                Hotel hotel = forEntity.getBody();

                                System.out.println("Hotel get from id is: " + hotel.toString());


                                logger.info("response status code: {}", forEntity.getStatusCode());

                                rating.setHotel(hotel);
                                return rating;
                            }

                            )

                    .collect(Collectors.toList());

            user.setRatings(ratingList);

        return user;
    }
}
