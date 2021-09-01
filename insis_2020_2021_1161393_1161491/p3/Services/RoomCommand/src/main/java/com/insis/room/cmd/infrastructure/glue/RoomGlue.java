package com.insis.room.cmd.infrastructure.glue;

import com.insis.room.cmd.infrastructure.dto.RoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(url = "https://jsonplaceholder.typicode.com", decode404 = true)
public interface RoomGlue {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<RoomDTO> getAllRooms();
}
