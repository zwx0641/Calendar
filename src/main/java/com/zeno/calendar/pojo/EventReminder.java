package com.zeno.calendar.pojo;

import java.util.Date;
import javax.persistence.*;

public class EventReminder {
    @Id
    private String email;

    @Column(name = "reminder_text")
    private String reminderText;

    @Column(name = "specific_day")
    private Date specificDay;

    @Column(name = "specific_time")
    private Date specificTime;

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return reminder_text
     */
    public String getReminderText() {
        return reminderText;
    }

    /**
     * @param reminderText
     */
    public void setReminderText(String reminderText) {
        this.reminderText = reminderText == null ? null : reminderText.trim();
    }

    /**
     * @return specific_day
     */
    public Date getSpecificDay() {
        return specificDay;
    }

    /**
     * @param specificDay
     */
    public void setSpecificDay(Date specificDay) {
        this.specificDay = specificDay;
    }

    /**
     * @return specific_time
     */
    public Date getSpecificTime() {
        return specificTime;
    }

    /**
     * @param specificTime
     */
    public void setSpecificTime(Date specificTime) {
        this.specificTime = specificTime;
    }
}