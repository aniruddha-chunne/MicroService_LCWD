package com.lcwd.user.service.UserService.controllers;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.flogger.Flogger;
import org.apache.http.HttpStatus;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

//import static io.github.resilience4j.circuitbreaker.configure.RxJava2CircuitBreakerAspectExt.logger;
//
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        System.out.println("Create User");
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(user1);
    }

    int retrycount = 1;

//    @CircuitBreaker(name = "RatingAndHotelCircuitBreaker",fallbackMethod = "ratingHotelFallbackMethod")
//    @Retry(name = "RatingHotelService", fallbackMethod = "ratingHotelFallbackMethod")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallbackMethod" )
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user  = userService.getUser(userId);
        retrycount++;
        System.out.println(retrycount + ": attempt");
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>>getAllUser()
    {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //creating fall back method for circuit breaker

    public ResponseEntity<User> ratingHotelFallbackMethod(String userId, Exception ex)
    {
        System.out.println("Have issue with the calling of service"+ userId +"::"+ex.getMessage());


//        User user  = userService.getUser(userId);

        User user  = User.builder()
                .email("dummy@gmail.com")
                .name("dummyname")
                .about("the user is dummy becuase some service is down")
                .userId("1424444")
                .build();
        return new ResponseEntity<>(user, org.springframework.http.HttpStatus.OK);

    }




}
