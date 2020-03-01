package com.zeno.calendar.service;

import com.zeno.calendar.mapper.EventMapper;
import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Calendar;
import java.util.Date;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Event> getDetailsOfEvent(String id) {
        Example eventExample = new Example(Event.class);
        Example.Criteria criteria = eventExample.createCriteria();
        criteria.andEqualTo("id", id);
        return eventMapper.selectByExample(eventExample);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean updateEventTime(String id) {
        Example eventExample = new Example(Event.class);
        Example.Criteria criteria = eventExample.createCriteria();
        criteria.andEqualTo("id", id);
        List<Event> eventList = eventMapper.selectByExample(eventExample);

        if (eventList.isEmpty()) {
            return false;
        }

        // Judge repetition type and update the next remindTime according to the type
        for (Event event : eventList) {
            Event updater = new Event();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(event.getFromTime());
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(event.getEndTime());
            switch (event.getRepetition()) {
                case 1:
                    updater.setFromTime(new Date(event.getFromTime().getTime() + 24*60*60*1000));
                    updater.setEndTime(new Date(event.getEndTime().getTime() + 24*60*60*1000));
                    eventMapper.updateByExampleSelective(updater, eventExample);
                    break;
                case 2:
                    updater.setFromTime(new Date(event.getFromTime().getTime() + 24*60*60*1000*7));
                    updater.setEndTime(new Date(event.getEndTime().getTime() + 24*60*60*1000*7));
                    eventMapper.updateByExampleSelective(updater, eventExample);
                    break;
                case 3:
                    calendar.add(Calendar.MONTH, 1);
                    calendar2.add(Calendar.MONTH, 1);
                    updater.setFromTime(calendar.getTime());
                    updater.setEndTime(calendar2.getTime());
                    eventMapper.updateByExampleSelective(updater, eventExample);
                    break;
                case 4:
                    calendar.add(Calendar.YEAR, 1);
                    calendar2.add(Calendar.YEAR, 1);
                    updater.setFromTime(calendar.getTime());
                    updater.setEndTime(calendar2.getTime());
                    eventMapper.updateByExampleSelective(updater, eventExample);
                    break;
                default:
            }
        }

        return true;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean editEvent(Event event) {
        Example example = new Example(Event.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", event.getId());

        if (eventMapper.selectOneByExample(example) != null) {
            eventMapper.updateByExampleSelective(event, example);
            return true;
        }
        return false;
    }
}
