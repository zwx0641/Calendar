package com.zeno.calendar.pojo;

import java.util.Date;
import javax.persistence.*;

public class Reminder {
    @Id
    @Column(name = "ID")
    private String id;

    private String email;

    @Column(name = "Remind_Text")
    private String remindText;

    @Column(name = "Remind_Day")
    private Date remindDay;

    @Column(name = "Remind_Time")
    private Date remindTime;

    @Column(name = "Repetition")
    private Integer repetition;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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
     * @return Remind_Text
     */
    public String getRemindText() {
        return remindText;
    }

    /**
     * @param remindText
     */
    public void setRemindText(String remindText) {
        this.remindText = remindText == null ? null : remindText.trim();
    }

    /**
     * @return Remind_Day
     */
    public Date getRemindDay() {
        return remindDay;
    }

    /**
     * @param remindDay
     */
    public void setRemindDay(Date remindDay) {
        this.remindDay = remindDay;
    }

    /**
     * @return Remind_Time
     */
    public Date getRemindTime() {
        return remindTime;
    }

    /**
     * @param remindTime
     */
    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    /**
     * @return Repetition
     */
    public Integer getRepetition() {
        return repetition;
    }

    /**
     * @param repetition
     */
    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }
}