package com.insis.room.cmd.controller.dtos;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class CreateRoomDTO {

    @NotNull
    @Schema(description="Room name", maxLength=10)
    private String roomId;

    public CreateRoomDTO() {
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

}
