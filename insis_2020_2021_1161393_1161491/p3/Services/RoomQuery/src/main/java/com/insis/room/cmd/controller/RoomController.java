package com.insis.room.cmd.controller;


import com.insis.room.cmd.controller.dtos.RoomResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PathVariable;

public interface RoomController {

    RoomResponseDTO findById(@Parameter(description = "id of room to be searched")
                  @PathVariable String roomId);
}
