package com.sportconnection.sccoreapi.mapper;

import com.sportconnection.sccoreapi.dto.ProfileDTO;
import com.sportconnection.sccoreapi.entity.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper implements Mapper<ProfileDTO, ProfileEntity> {
    @Override
    public ProfileEntity convertToEntity(ProfileDTO dto) {
      return ProfileEntity.builder()
              .id(dto.getId())
              .achievements(dto.getAchievements())
              .name(dto.getName())
              .phone(dto.getPhone())
              .score(dto.getScore())
              .level(dto.getLevel())
              .friends(dto.getFriends())
              .eventsParticipated(dto.getEventsParticipated())
              .build();
    }

    @Override
    public ProfileDTO convertToDTO(ProfileEntity entity) {
        return ProfileDTO.builder()
                .id(entity.getId())
                .achievements(entity.getAchievements())
                .name(entity.getName())
                .phone(entity.getPhone())
                .score(entity.getScore())
                .level(entity.getLevel())
                .friends(entity.getFriends())
                .eventsParticipated(entity.getEventsParticipated())
                .build();
    }
}
