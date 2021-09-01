package com.insis.room.cmd.controller.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RoomResponseDTO {

    @Schema(description="Room name", maxLength=10)
    private String roomId;

    List<ScheduleResponseDTO> roomSchedule;

    public RoomResponseDTO() {
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<ScheduleResponseDTO> getRoomSchedule() {
        return roomSchedule;
    }

    public void setRoomSchedule(List<ScheduleResponseDTO> roomSchedule) {
        this.roomSchedule = roomSchedule;
    }
}
