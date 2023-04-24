package com.sportconnection.sccoreapi.service;

import com.sportconnection.sccoreapi.dto.EventDTO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    EventDTO create(EventDTO dto);
    EventDTO update(Long id, EventDTO dto);
    EventDTO get(Long id);
    List<EventDTO> list();
    void delete(Long id);
}
