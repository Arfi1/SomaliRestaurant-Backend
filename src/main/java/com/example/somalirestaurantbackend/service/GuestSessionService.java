package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.GuestSession;
import com.example.somalirestaurantbackend.repository.GuestSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestSessionService {

    private final GuestSessionRepository guestSessionRepository;

    @Autowired
    public GuestSessionService(GuestSessionRepository guestSessionRepository) {
        this.guestSessionRepository = guestSessionRepository;
    }

    public GuestSession createSession(GuestSession session) {
        // Sæt oprettelsesdato og eventuelle standardværdier her
        return guestSessionRepository.save(session);
    }

    public GuestSession getSessionById(String sessionId) {
        return guestSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Guest session not found: " + sessionId));
    }

    public void deleteSession(String sessionId) {
        Optional<GuestSession> session = guestSessionRepository.findById(sessionId);
        if (session.isEmpty()) {
            throw new RuntimeException("Guest session not found: " + sessionId);
        }
        guestSessionRepository.deleteById(sessionId);
    }
}
