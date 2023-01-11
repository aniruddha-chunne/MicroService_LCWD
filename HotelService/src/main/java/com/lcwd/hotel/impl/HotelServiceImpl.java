package com.lcwd.hotel.impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Component
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel create (Hotel hotel)
    {
        String randomUserId   = UUID.randomUUID().toString();
        hotel.setId(randomUserId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("User with given id is not found on server !! : " + id));
    }
}
