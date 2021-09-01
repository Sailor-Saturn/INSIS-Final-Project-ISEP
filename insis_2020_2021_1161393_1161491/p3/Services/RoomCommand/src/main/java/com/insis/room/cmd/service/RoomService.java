package com.insis.room.cmd.service;

import com.insis.room.cmd.controller.dtos.ScheduleRequestDTO;
import com.insis.room.cmd.domain.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {

   Room bookFirstRoomAvailable(ScheduleRequestDTO schedule);

    Room createRoom(Room room);

    void deleteRoom(String id) throws Exception;
}
