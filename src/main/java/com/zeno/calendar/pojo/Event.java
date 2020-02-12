package com.zeno.calendar.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "eventdata")
public class Event {
    @Id
    @Column(name = "ID")
    private String id;

    private String email;

    @Column(name = "event_name")
    private String eventName;

    private String location;

    private String remark;

    @Column(name = "from_time")
    private Date fromTime;

    @Column(name = "end_time")
    private Date endTime;

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
     * @return event_name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return from_time
     */
    public Date getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime
     */
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return repetition
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