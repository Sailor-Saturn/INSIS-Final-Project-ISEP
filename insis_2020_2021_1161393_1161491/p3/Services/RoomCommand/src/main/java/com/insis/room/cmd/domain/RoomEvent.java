package com.insis.room.cmd.domain;


import java.io.Serializable;

public class RoomEvent implements Serializable {

    //@Schema(description="Event id", maxLength=10)
    private String eventId;
   // @Schema(description="The type or name of event", maxLength=20)
    private String eventDescription;

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

    public RoomEvent(String eventId, String eventDescription) {
        this.eventId = eventId;
        this.eventDescription = eventDescription;
    }

    public RoomEvent() {
    }
}
