package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.service.EventService;
import com.zeno.calendar.utils.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author rf
 */
@RestController
@Api(value = "Event APIs", tags = {"Controller for  Event APIs"})
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/save")
    public JSONResult saveEvent(@RequestBody Event event) {
        // 1.If belongs to no user, remind user to login
        if (StringUtils.isEmpty(event.getEmail())) {
            return JSONResult.errorMsg("Please login to set a reminder.");
        }

        if (event.getId() == null) {
            // 2.Save reminder
            eventService.insertEvent(event);
        } else {
            eventService.editEvent(event);
        }

        return JSONResult.ok();
    }

    @PostMapping("/query")
    public JSONResult queryEvent(String email) {
        List<Event> eventList = eventService.getEvent(email);

        // Sort events according to time
        if (!eventList.isEmpty()) {
            eventList.sort(new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return o1.getFromTime().compareTo(o2.getFromTime());
                }
            });
            return JSONResult.ok(eventList);
        }
        return JSONResult.errorMsg("Unable to find an event.");
    }

    @PostMapping("/drop")
    public JSONResult dropEvent(String id) {
        eventService.deleteEvent(id);
        return JSONResult.ok();
    }

    @PostMapping("/detail")
    public JSONResult detailReminder(String id) {
        if (eventService.getDetailsOfEvent(id) == null) {
            return JSONResult.errorMsg("Unable to find an event");
        }
        return JSONResult.ok(eventService.getDetailsOfEvent(id));
    }

    @PostMapping("/update")
    public JSONResult updateEvent(String id) {
        if (eventService.updateEventTime(id)) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("Unable to update");
    }

}
