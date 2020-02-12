package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.service.ReminderService;
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
public class RemindController {
    @Autowired
    private ReminderService reminderService;

    @PostMapping("/savereminder")
    public IMoocJSONResult publishReminder(@RequestBody Reminder reminder) throws Exception {

        // 1.If belongs to no user, remind user to login
        if (StringUtils.isEmpty(reminder.getEmail())) {
            return IMoocJSONResult.errorMsg("Please login to set a reminder.");
        }

        // 2.Save reminder
        reminderService.saveReminder(reminder);

        return IMoocJSONResult.ok();
    }

    /**
     * Get reminders according to user email
     * @param email 
     * @return
     * @throws Exception
     */
    @PostMapping("/queryreminder")
    public IMoocJSONResult getReminder(String email) throws Exception {
        List<Reminder> reminders = reminderService.queryReminder(email);
        if (!reminders.isEmpty()) {
            return IMoocJSONResult.ok(reminders);
        }
        return IMoocJSONResult.errorMsg("Unable to find a reminder");
    }

    /**
     * Delete a reminder according to its id
     * @param id
     * @return if it is successful
     * @throws Exception
     */
    @PostMapping("/dropreminder")
    public IMoocJSONResult dropReminder(String id) throws Exception {
        if (reminderService.deleteReminder(id)) {
            return IMoocJSONResult.ok();
        }
        return IMoocJSONResult.errorMsg("error");
    }

    /**
     * update a reminder according to its id
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/updatereminder")
    public IMoocJSONResult updateReminder(String id) throws Exception {
        if (reminderService.updateTime(id)) {
            return IMoocJSONResult.ok();
        }
        return IMoocJSONResult.errorMsg("error");
    }

    /**
     * Get the details of a reminder
     * @param email
     * @param remindText
     * @return
     */
    @PostMapping("/detailreminder")
    public IMoocJSONResult detailReminder(String email, String remindText) {
        List<Reminder> reminders = reminderService.getDetailsOfReminder(email,remindText);
        if (!reminders.isEmpty()) {
            return IMoocJSONResult.ok(reminders);
        }
        return IMoocJSONResult.errorMsg("Unable to find a reminder");
    }
}
