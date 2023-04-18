package com.sportconnection.sccoreapi.mapper;

import com.sportconnection.sccoreapi.dto.UserDTO;
import com.sportconnection.sccoreapi.entity.UserEntity;

public class UserMapper {

    public UserDTO convertToDTO(UserEntity entity) {
        return new UserDTO(
                entity.getId(),
                entity.getUsername()
        );
    }

}
