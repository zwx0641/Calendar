package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.service.ReminderService;
import com.zeno.calendar.utils.IMoocJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @PostMapping("/queryreminder")
    public IMoocJSONResult getReminder(String email) throws Exception {
        List<Reminder> reminders = reminderService.queryReminder(email);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return IMoocJSONResult.ok(reminders);
    }
}
