package com.example.events_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.events_backend.Entities.Event;

public interface EventRepositroy extends JpaRepository<Event, Integer>{
    
}
