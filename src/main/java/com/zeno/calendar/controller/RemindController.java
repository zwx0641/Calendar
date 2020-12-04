package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.service.ReminderService;
import com.zeno.calendar.utils.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author rf
 */
@RestController
@Api(value = "Reminder APIs", tags = {"Controller for Reminder APIs"})
@RequestMapping("/reminder")
public class RemindController {
    @Autowired
    private ReminderService reminderService;

    @PostMapping("/save")
    public JSONResult publishReminder(@RequestBody Reminder reminder) throws Exception {

        // 1.If belongs to no user, remind user to login
        if (StringUtils.isEmpty(reminder.getEmail())) {
            return JSONResult.errorMsg("Please login to set a reminder.");
        }

        if (reminder.getId() == null) {
            // 2.Save reminder
            reminderService.saveReminder(reminder);
        } else {
            reminderService.editReminder(reminder);
        }

        return JSONResult.ok();
    }

    /**
     * Get reminders according to user email
     * @param email 
     * @return
     * @throws Exception
     */
    @PostMapping("/query")
    public JSONResult getReminder(String email) throws Exception {
        List<Reminder> reminders = reminderService.queryReminder(email);
        if (!reminders.isEmpty()) {
            return JSONResult.ok(reminders);
        }
        return JSONResult.errorMsg("Unable to find a reminder");
    }

    /**
     * Delete a reminder according to its id
     * @param id
     * @return if it is successful
     * @throws Exception
     */
    @PostMapping("/drop")
    public JSONResult dropReminder(String id) throws Exception {
        if (reminderService.deleteReminder(id)) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("error");
    }

    /**
     * update a reminder according to its id
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/update")
    public JSONResult updateReminder(String id) throws Exception {
        if (reminderService.updateTime(id)) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("error");
    }

    /**
     * Get the details of a reminder
     * @param email
     * @param remindText
     * @return
     */
    @PostMapping("/detail")
    public JSONResult detailReminder(String email, String remindText) {
        List<Reminder> reminders = reminderService.getDetailsOfReminder(email,remindText);
        if (!reminders.isEmpty()) {
            return JSONResult.ok(reminders);
        }
        return JSONResult.errorMsg("Unable to find a reminder");
    }
}
