package com.lcwd.user.service.UserService.repositories;

import com.lcwd.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
    // if you want any to implement any custom method or query
    // write
}
