package com.dayshare.events;

import com.dayshare.group.Group;
import com.dayshare.parent.Parent;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="calendar_events")
public class Event {
    @Id
    @Expose
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;
    @ManyToOne
    @JoinColumn(name = "primary_parent_id", insertable=false, updatable=false)
    private Parent primaryParent;
    @Expose
    @Column(name = "primary_parent_id")
    private int primaryParentId;
    @ManyToOne
    @JoinColumn(name = "group_id", insertable=false, updatable=false)
    private Group group;
    @Expose
    @Column(name = "group_id")
    private int groupId;
    @Expose
    @Column(name = "event_title")
    private String eventTitle;
    @Expose
    @Column(name = "event_description")
    private String eventDescription;
    @Expose
    @Column(name = "event_date")
    private Date eventDate;
    @Expose
    @Column(name = "start_time")
    private Date startTime;
    @Expose
    @Column(name = "end_time")
    private Date endTime;
    @Expose
    private boolean personal;
    @Expose
    private boolean reminder;
    @Expose
    @Column(name = "reminder_time")
    private Date reminderTime;

    public Event() {
    }

    public Event(int primaryParentId, int groupId, String eventTitle, String eventDescription, Date eventDate, Date startTime, Date endTime, boolean personal, boolean reminder, Date reminderTime) {
        this.primaryParentId = primaryParentId;
        this.groupId = groupId;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personal = personal;
        this.reminder = reminder;
        this.reminderTime = reminderTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public int getPrimaryParentId() {
        return primaryParentId;
    }

    public void setPrimaryParentId(int primaryParentId) {
        this.primaryParentId = primaryParentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isPersonal() {
        return personal;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }
}

