package com.zeno.calendar.service;

import com.zeno.calendar.mapper.EventMapper;
import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Event> getEvent(String email) {
        Example eventExample = new Example(Event.class);
        Example.Criteria criteria = eventExample.createCriteria();
        criteria.andEqualTo("email", email);
        return eventMapper.selectByExample(eventExample);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteEvent(String id) {
        Example eventExample = new Example(Event.class);
        Example.Criteria criteria = eventExample.createCriteria();
        criteria.andEqualTo("id", id);
        eventMapper.deleteByExample(eventExample);
    }

    @Override
    public List<Event> getDetailsOfEvent(String id) {
        Example eventExample = new Example(Event.class);
        Example.Criteria criteria = eventExample.createCriteria();
        criteria.andEqualTo("id", id);
        return eventMapper.selectByExample(eventExample);
    }
}
