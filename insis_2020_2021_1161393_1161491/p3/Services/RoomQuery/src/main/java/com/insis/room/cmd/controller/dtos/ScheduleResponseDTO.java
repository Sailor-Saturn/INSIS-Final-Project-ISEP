package com.insis.room.cmd.controller.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ScheduleResponseDTO {

    @Schema(description="schedule id", maxLength=10)
    private String scheduleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date beginningHour;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date endingHour;

    @NotNull
    private String userId;

    @NotNull
    @Schema(description="Event id", maxLength=10)
    private String eventId;

    @NotNull
    @Schema(description="The type or name of event", maxLength=20)
    private String eventDescription;

    public ScheduleResponseDTO() {
    }

    public ScheduleResponseDTO(String scheduleId, Date beginningHour, Date endingHour, String userId, String eventId, String eventDescription) {
        this.scheduleId = scheduleId;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.userId = userId;
        this.eventId = eventId;
        this.eventDescription = eventDescription;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public void setBeginningHour(Date beginningHour) {
        this.beginningHour = beginningHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
