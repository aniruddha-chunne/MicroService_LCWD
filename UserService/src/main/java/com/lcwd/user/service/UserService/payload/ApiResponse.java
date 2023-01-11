package com.lcwd.user.service.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse
{
    private String message;
    private boolean success;
    private HttpStatus status;
}
