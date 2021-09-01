package com.insis.room.cmd.controller;

import com.insis.room.cmd.controller.dtos.CreateRoomDTO;
import com.insis.room.cmd.controller.dtos.ScheduleRequestDTO;
import com.insis.room.cmd.domain.Room;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface RoomController {

    @Operation(summary = "Create a Room with an empty schedule.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Room created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content) })
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createRoom(@RequestBody CreateRoomDTO room);

    @Operation(summary = "Book an event in a Room.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room reserved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> bookRoomById(@Parameter(description = "id of room to be booked") @PathVariable("id") String roomId,
                                   @RequestBody ScheduleRequestDTO schedule);

    @Operation(summary = "Book an event in any Room that is available.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room reserved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class)) }),
            @ApiResponse(responseCode = "404", description = "No Room available",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> bookAnyRoomAvailable(@RequestBody ScheduleRequestDTO schedule);

    @Operation(summary = "Delete a room.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    ResponseEntity<?> deleteRoom(@Parameter(description = "id of room to be deleted") @PathVariable("id") String id);
}
