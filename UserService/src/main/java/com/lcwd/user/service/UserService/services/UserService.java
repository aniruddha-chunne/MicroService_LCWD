package com.lcwd.user.service.UserService.services;

import com.lcwd.user.service.UserService.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
    //user operations

    User saveUser (User user);

    List<User> getAllUser();

    User getUser(String userId);




}
