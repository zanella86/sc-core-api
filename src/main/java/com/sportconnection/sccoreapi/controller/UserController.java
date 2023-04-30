package com.sportconnection.sccoreapi.controller;

import com.sportconnection.sccoreapi.dto.EventDTO;
import com.sportconnection.sccoreapi.dto.RegisterUserDTO;
import com.sportconnection.sccoreapi.dto.UserDTO;
import com.sportconnection.sccoreapi.security.dto.AuthDTO;
import com.sportconnection.sccoreapi.security.dto.JwtDTO;
import com.sportconnection.sccoreapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public JwtDTO login(@RequestBody AuthDTO authDTO) {
        return this.userService.auth(authDTO);
    }

    @PostMapping("register")
    public UserDTO register(@RequestBody RegisterUserDTO registerUserDTO) {
        return this.userService.create(registerUserDTO);
    }
}
