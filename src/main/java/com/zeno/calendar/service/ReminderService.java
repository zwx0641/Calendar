package com.zeno.calendar.service;

import com.zeno.calendar.pojo.Reminder;

import java.util.List;

/**
 * @author rf
 */
public interface ReminderService {
    /**
     * Save a reminder to the database
     * @param reminder
     */
    void saveReminder(Reminder reminder);

    /**
     *
     * @param email
     * @return reminder
     */
    List<Reminder> queryReminder(String email);

    /**
     *
     * @param id
     */
    boolean deleteReminder(String id);
}
