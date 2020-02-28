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
     * Query a user's reminders
     * @param email
     * @return reminder
     */
    List<Reminder> queryReminder(String email);

    /**
     * Delete a reminder
     * @param id
     */
    boolean deleteReminder(String id);

    /**
     * Update reminder's time
     * @param id
     * @return
     */
    boolean updateTime(String id);

    /**
     * Query a reminder for its details
     * @param email
     * @param remindText
     */
    List<Reminder> getDetailsOfReminder(String email, String remindText);

    /**
     * Update a reminder's info
     * @param reminder
     * @return
     */
    boolean editReminder(Reminder reminder);
}
