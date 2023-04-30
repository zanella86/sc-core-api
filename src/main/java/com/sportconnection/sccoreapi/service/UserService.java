package com.sportconnection.sccoreapi.service;

import com.sportconnection.sccoreapi.dto.RegisterUserDTO;
import com.sportconnection.sccoreapi.security.dto.AuthDTO;
import com.sportconnection.sccoreapi.security.dto.JwtDTO;
import com.sportconnection.sccoreapi.dto.UserDTO;

public interface UserService {

    JwtDTO auth(AuthDTO authDTO);
    UserDTO create(RegisterUserDTO registerUserDTO);



}
