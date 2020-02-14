package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.service.EventService;
import com.zeno.calendar.utils.IMoocJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author rf
 */
@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/saveevent")
    public IMoocJSONResult saveEvent(@RequestBody Event event) {
        // 1.If belongs to no user, remind user to login
        if (StringUtils.isEmpty(event.getEmail())) {
            return IMoocJSONResult.errorMsg("Please login to set a reminder.");
        }

        // 2.Save reminder
        eventService.insertEvent(event);

        return IMoocJSONResult.ok();
    }

    @PostMapping("/queryevent")
    public IMoocJSONResult queryEvent(String email) {
        List<Event> eventList = eventService.getEvent(email);
        if (!eventList.isEmpty()) {
            return IMoocJSONResult.ok(eventList);
        }
        return IMoocJSONResult.errorMsg("Unable to find an event.");
    }
}
