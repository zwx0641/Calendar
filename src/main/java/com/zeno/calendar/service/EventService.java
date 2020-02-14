package com.zeno.calendar.service;

import com.zeno.calendar.pojo.Event;

import java.util.List;

public interface EventService {
    /**
     * save a event
     * @param event
     */
    void insertEvent(Event event);

    /**
     * get events
     * @param email
     * @return
     */
    List<Event> getEvent(String email);
}
