package com.sportconnection.sccoreapi.service.impl;

import com.sportconnection.sccoreapi.dto.EventDTO;
import com.sportconnection.sccoreapi.mapper.EventMapper;
import com.sportconnection.sccoreapi.repository.EventRepository;
import com.sportconnection.sccoreapi.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    EventRepository repository;
    EventMapper mapper;


    @Override
    public EventDTO create(EventDTO dto) {
        var entity = mapper.convertToEntity(dto);
        entity = repository.save(entity);
        return mapper.convertToDTO(entity);
    }

    @Override
    public EventDTO update(Long id, EventDTO dto) {
        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());

        var updateEntity = mapper.convertToEntity(dto);
        updateEntity.setId(id);

        updateEntity = repository.save(updateEntity);

        return mapper.convertToDTO(updateEntity);
    }

    @Override
    public EventDTO get(Long id) {
        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());
        return mapper.convertToDTO(entity.get());
    }

    @Override
    public List<EventDTO> list() {
        var entities = repository.findAll();
        if (Objects.isNull(entities) || entities.isEmpty()) return new ArrayList<>();
        return entities.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());
        repository.delete(entity.get());
    }
}
