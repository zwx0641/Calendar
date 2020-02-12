package com.zeno.calendar.service;

import com.zeno.calendar.mapper.EventMapper;
import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertEvent(Event event) {
        String eventId = sid.nextShort();
        event.setId(eventId);
        eventMapper.insert(event);
    }
}
