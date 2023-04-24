package com.sportconnection.sccoreapi.mapper;

import com.sportconnection.sccoreapi.dto.EventDTO;
import com.sportconnection.sccoreapi.entity.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper implements Mapper<EventDTO, EventEntity> {
    @Override
    public EventEntity convertToEntity(EventDTO dto) {
        return EventEntity.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .paid(dto.getPaid())
                .time(dto.getTime())
                .typeEvent(dto.getTypeEvent())
                .name(dto.getName())
                .description(dto.getDescription())
                .icon(dto.getIcon())
                .frequency(dto.getFrequency())
                .build();
    }

    @Override
    public EventDTO convertToDTO(EventEntity entity) {
        return EventDTO.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .paid(entity.getPaid())
                .time(entity.getTime())
                .typeEvent(entity.getTypeEvent())
                .name(entity.getName())
                .description(entity.getDescription())
                .icon(entity.getIcon())
                .frequency(entity.getFrequency())
                .build();
    }
}
