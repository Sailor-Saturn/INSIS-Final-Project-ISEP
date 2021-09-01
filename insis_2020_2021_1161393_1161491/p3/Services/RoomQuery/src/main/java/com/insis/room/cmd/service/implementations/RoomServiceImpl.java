package com.insis.room.cmd.service.implementations;

import com.insis.room.cmd.service.RoomService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl implements RoomService {

    private static final String QUEUE = "insis.queue1";

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(String orderStatus) {
        System.out.println("Message received from queue : " + orderStatus);
    }
}
