package com.insis.room.cmd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

   // @Schema(description="Room name", maxLength=10)
    private String roomId;
   // @Schema(description="Room schedule")
    private List<Schedule> roomSchedules;

    public Room(String roomId, List<com.insis.room.cmd.domain.Schedule> roomSchedules) {
        this.roomId = roomId;
        this.roomSchedules = roomSchedules;
    }

    public Room(String roomId) {
        this.roomId = roomId;
        roomSchedules = new ArrayList<>();
    }

    public Room() {
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<com.insis.room.cmd.domain.Schedule> getRoomSchedules() {
        return roomSchedules;
    }

    public void setRoomSchedules(List<com.insis.room.cmd.domain.Schedule> roomSchedules) {
        this.roomSchedules = roomSchedules;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomSchedules=" + roomSchedules +
                '}';
    }
}
