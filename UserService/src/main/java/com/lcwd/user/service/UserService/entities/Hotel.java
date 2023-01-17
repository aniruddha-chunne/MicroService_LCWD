package com.lcwd.user.service.UserService.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel
{
    private String Id;
    private String name;
    private String location;
    private String about;
}
