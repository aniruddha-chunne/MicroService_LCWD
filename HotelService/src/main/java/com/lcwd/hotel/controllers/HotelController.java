package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hotels")
public class HotelController
{
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{HotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String HotelId)
    {
        Hotel Hotel  = hotelService.get(HotelId);
        return ResponseEntity.status(HttpStatus.OK).body(Hotel);
    }


    @GetMapping
    public ResponseEntity<List<Hotel>>getAll()
    {
        List<Hotel> allHotel = hotelService.getAll();
        return ResponseEntity.ok(allHotel);
    }


}
