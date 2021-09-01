package com.insis.room.cmd.controller.Impl;

import com.insis.room.cmd.controller.RoomController;
import com.insis.room.cmd.controller.dtos.CreateRoomDTO;
import com.insis.room.cmd.controller.dtos.RoomResponseDTO;
import com.insis.room.cmd.controller.dtos.ScheduleRequestDTO;
import com.insis.room.cmd.domain.Room;
import com.insis.room.cmd.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/q/rooms")
public class RoomControllerImpl implements RoomController {

    @Autowired
    private RoomService roomService;


    @Operation(summary = "Get a room by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the room",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Room not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public RoomResponseDTO findById(@Parameter(description = "id of room to be searched")
                         @PathVariable String roomId) {
        //return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
        //TODO
        return null;
    }

    @Operation(summary = "Get a list of all rooms. Filtering by status is possible.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the rooms",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Rooms not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET)
    public List<RoomResponseDTO> getAllRooms() {
        //return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
        //TODO
        return null;
    }
}
