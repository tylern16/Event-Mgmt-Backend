package com.example.events_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.events_backend.Entities.Event;
import com.example.events_backend.repositories.EventRepositroy;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EventController {
    
    //property to hold event repo
    public EventRepositroy Events;

    //recieve event repo via dependency onjection
    public EventController(EventRepositroy Events){
        this.Events = Events;
    }

    //GET
    @CrossOrigin
    @GetMapping("/events")
    public List<Event> index(){
        return Events.findAll();
    }

    @CrossOrigin
    @GetMapping("/events/{id}")
    public Optional<Event> show(@PathVariable int id) {
        return Events.findById(id);
    }

    @CrossOrigin
    @PostMapping(value="/events")
    public List<Event> create(@RequestBody Event newEvent){
        Events.save(newEvent);
        return Events.findAll();
    }

    @CrossOrigin
    @PutMapping("/events/{id}")
    public List<Event> update(@RequestBody Event fixEvent, @PathVariable int id){
        Events.findById(id).map(Event -> {

            Event.setTitle(fixEvent.getTitle());
            Event.setDate(fixEvent.getDate());
            Event.setEventImage(fixEvent.getEventImage());
            Event.setCity(fixEvent.getCity());
            return Event;
        });

        return Events.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/events/{id}")
    public List<Event> destroy(@PathVariable int id){
        Events.deleteById(id);
        return Events.findAll();
    }
    
}
