package com.sportconnection.sccoreapi.dto;

import com.sportconnection.sccoreapi.dto.enums.LevelEnum;
import com.sportconnection.sccoreapi.entity.EventEntity;
import com.sportconnection.sccoreapi.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class ProfileDTO {
    private Long id;
    private String name;
    private String phone;
    private LevelEnum level;
    private int score;
    private int eventsParticipated;
    private int achievements;
    private int friends;
    private Set<EventDTO> events = new HashSet<>();
    private Long userId;
}
