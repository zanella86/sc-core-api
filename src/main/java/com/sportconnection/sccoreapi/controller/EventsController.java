package com.sportconnection.sccoreapi.controller;

import com.sportconnection.sccoreapi.dto.EventDTO;
import com.sportconnection.sccoreapi.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("events")
public class EventsController {
    private final EventService service;

   /* @PostMapping
    public ResponseEntity<Object> post(@RequestBody EventDTO eventDTO, @RequestHeader Map<String, String> headers) {
        var response = service.create(eventDTO);
        return ResponseEntity.created(URI.create("/event/" + response.getId())).body(response);
    }*/

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> get(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        var eventDTO = service.get(id);
        return ResponseEntity.ok().body(eventDTO);
    }

    @GetMapping
    public ResponseEntity<Object> list(@RequestHeader Map<String, String> headers) {
        var events = service.list();
        return ResponseEntity.ok(events);
    }
/*
    @PatchMapping("{id}")
    public ResponseEntity<Object> patch(@PathVariable Long id, @RequestBody EventDTO eventDTO, @RequestHeader Map<String, String> headers) {
        var event = service.update(id, eventDTO);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        service.delete(id);
    }
*/
}
