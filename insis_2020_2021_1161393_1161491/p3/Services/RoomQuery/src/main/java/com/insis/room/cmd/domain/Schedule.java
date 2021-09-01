package com.insis.room.cmd.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Schedule.class)
public class Schedule implements Serializable {

    private String scheduleId;
    @Schema(description="the date and hour of the event start")
    private Date beginningHour;
    @Schema(description="the date and hour of the event end")
    private Date endingHour;
    private RoomEvent roomEvent;
    @Schema(description="the status of this booking")
    private ScheduleStatus status;

    public Schedule(String scheduleId, Date beginningHour, Date endingHour, RoomEvent roomEvent) {
        this.scheduleId = scheduleId;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.roomEvent = roomEvent;
        this.status = ScheduleStatus.TEMPORARILY_RESERVED;
    }

    public Schedule() {

    }

    public void confirmReservation() {
        this.status = ScheduleStatus.RESERVED;
    }
    
    public String getScheduleId() {
        return scheduleId;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setBeginningHour(Date beginningHour) {
        this.beginningHour = beginningHour;
    }

    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
    }

    public RoomEvent getRoomEvent() {
        return roomEvent;
    }

    public void setRoomEvent(RoomEvent roomEvent) {
        this.roomEvent = roomEvent;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", beginningHour=" + beginningHour +
                ", endingHour=" + endingHour +
                ", roomEvent='" + roomEvent + '\'' +
                '}';
    }
}
