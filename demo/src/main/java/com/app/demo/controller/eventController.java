package com.app.demo.controller;


import com.app.demo.model.event;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/events")
public class eventController {
    private List<event> events = new ArrayList<>();

    @GetMapping
    public List<event> getAllEvents() {
        return events;
    }

    @PostMapping
    public String createEvent(@RequestBody event newEvent) {
        events.add(newEvent);
        return "Event created successfully";
    }

    @GetMapping("events/{id}")
    public event getEventById(@PathVariable int id) {
        return events.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("events/{id}")
    public String deleteEvent(@PathVariable int id) {
        events.removeIf(event -> event.getId() == id);
        return "Event deleted successfully";
    }
}
