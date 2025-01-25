package com.example.somalirestaurantbackend.controller;

import com.example.somalirestaurantbackend.model.GuestSession;
import com.example.somalirestaurantbackend.service.GuestSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest-sessions")
@CrossOrigin("*")
public class GuestSessionController {

    private final GuestSessionService guestSessionService;

    public GuestSessionController(GuestSessionService guestSessionService) {
        this.guestSessionService = guestSessionService;
    }

    @PostMapping
    public ResponseEntity<GuestSession> createSession(@RequestBody GuestSession session) {
        return ResponseEntity.ok(guestSessionService.createSession(session));
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<GuestSession> getSession(@PathVariable String sessionId) {
        return ResponseEntity.ok(guestSessionService.getSessionById(sessionId));
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteSession(@PathVariable String sessionId) {
        guestSessionService.deleteSession(sessionId);
        return ResponseEntity.noContent().build();
    }
}
