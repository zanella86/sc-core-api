package com.sportconnection.sccoreapi.controller;

import com.sportconnection.sccoreapi.dto.EventDTO;
import com.sportconnection.sccoreapi.dto.ProfileDTO;
import com.sportconnection.sccoreapi.service.EventService;
import com.sportconnection.sccoreapi.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("profiles")
public class ProfileController {
    private final ProfileService service;
    private final EventService eventService;

    /*
    @PostMapping
    public ResponseEntity<Object> post(@RequestBody ProfileDTO profileDTO, @RequestHeader Map<String, String> headers) {
        var response = service.create(profileDTO);
        return ResponseEntity.created(URI.create("/event/" + response.getId())).body(response);
    }
*/
    @GetMapping("{id}")
    public ResponseEntity<ProfileDTO> get(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        var profileDTO = service.get(id);
        return ResponseEntity.ok().body(profileDTO);
    }

    @GetMapping
    public ResponseEntity<Object> list(@RequestHeader Map<String, String> headers) {
        var events = service.list();
        return ResponseEntity.ok(events);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> patch(@PathVariable Long id, @RequestBody ProfileDTO profileDTO, @RequestHeader Map<String, String> headers) {
        var event = service.update(id, profileDTO);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        service.delete(id);
    }

    @PostMapping("{username}/events")
    public ResponseEntity<Object> post(@RequestBody EventDTO eventDTO, @RequestHeader Map<String, String> headers, @PathVariable String username) {
        eventDTO.setUsername(username);
        var response = eventService.create(eventDTO);
        return ResponseEntity.created(URI.create("/event/" + response.getId())).body(response);
    }

    @GetMapping("{username}/events/{idEvents}")
    public ResponseEntity<EventDTO> get(@PathVariable Long idEvents, @RequestHeader Map<String, String> headers, @PathVariable String username) {
        var eventDTO = eventService.get(idEvents, username);
        return ResponseEntity.ok().body(eventDTO);
    }

    @GetMapping("{username}/events")
    public ResponseEntity<Object> list(@RequestHeader Map<String, String> headers, @PathVariable String username) {
        var events = eventService.list(username);
        return ResponseEntity.ok(events);
    }

    @PatchMapping("{username}/events/{idEvents}")
    public ResponseEntity<Object> patch(@PathVariable Long idEvents, @RequestBody EventDTO eventDTO, @RequestHeader Map<String, String> headers, @PathVariable String username) {
        eventDTO.setUsername(username);
        var event = eventService.update(idEvents, eventDTO);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("{username}/events/{idEvents}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long idEvents, @RequestHeader Map<String, String> headers, @PathVariable String username) {
        eventService.delete(idEvents, username);
    }
}
