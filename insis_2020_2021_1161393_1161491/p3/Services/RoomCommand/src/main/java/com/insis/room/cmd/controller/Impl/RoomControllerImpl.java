package com.insis.room.cmd.controller.Impl;

import com.insis.room.cmd.controller.RoomController;
import com.insis.room.cmd.controller.dtos.CreateRoomDTO;
import com.insis.room.cmd.controller.dtos.ScheduleRequestDTO;
import com.insis.room.cmd.controller.mapper.RoomMapper;
import com.insis.room.cmd.domain.Room;
import com.insis.room.cmd.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomControllerImpl implements RoomController {

    @Autowired
    private RoomService roomService;


    @Override
    public ResponseEntity<?> createRoom(@RequestBody CreateRoomDTO roomRequest) {
        Room room = RoomMapper.fromDtoToDomain(roomRequest);
        try {
            roomService.createRoom(room);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @Override
    public ResponseEntity<?> bookRoomById(@Parameter(description = "id of room to be booked") @PathVariable("id") String roomId, @RequestBody ScheduleRequestDTO schedule) {
        //TODO
        return null;
    }

    @Override
    public ResponseEntity<?> bookAnyRoomAvailable(@RequestBody ScheduleRequestDTO schedule) {
        try{
            roomService.bookFirstRoomAvailable(schedule);
            return null;
            //TODO
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    public ResponseEntity<?> deleteRoom(@PathVariable("id") String id){
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
