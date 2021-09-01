package com.insis.room.cmd.service.implementations;

import com.insis.room.cmd.controller.dtos.ScheduleRequestDTO;
import com.insis.room.cmd.domain.Room;
import com.insis.room.cmd.infrastructure.glue.RoomGlue;
import com.insis.room.cmd.infrastructure.rabbit.Producer;
import com.insis.room.cmd.infrastructure.rabbit.RabbitConfig;
import com.insis.room.cmd.service.RoomService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class RoomServiceImpl implements RoomService {

/*
    @Autowired
    RoomGlue roomGlue;
*/

    @Autowired
    private RabbitTemplate template;

    @Autowired
    Producer producer;

    @Override
    public Room bookFirstRoomAvailable(ScheduleRequestDTO schedule) {
        try{
           // producer.sendRoom();
            //do something
        }catch (HttpClientErrorException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){

            }
        }
        return null;
    }

    @Override
    public Room createRoom(Room room) {
        //if 404 - create room
        // se existir - 400 bad request
        // validateProponent(proposal);
        return null;
    }

    @Override
    public void deleteRoom(String id) throws Exception {
        //TODO
        // make get to proposal query in order to check if proposal exists
        //if 404 - return 404
        try{
            producer.deleteRoom(id);
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }
}
