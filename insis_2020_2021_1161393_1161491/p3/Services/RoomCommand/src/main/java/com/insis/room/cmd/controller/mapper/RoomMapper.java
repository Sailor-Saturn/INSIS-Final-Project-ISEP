package com.insis.room.cmd.controller.mapper;

import com.insis.room.cmd.controller.dtos.CreateRoomDTO;
import com.insis.room.cmd.domain.Room;

public class RoomMapper {

    public static Room fromDtoToDomain(CreateRoomDTO roomRequest){
        return new Room(roomRequest.getRoomId());
    }
}
