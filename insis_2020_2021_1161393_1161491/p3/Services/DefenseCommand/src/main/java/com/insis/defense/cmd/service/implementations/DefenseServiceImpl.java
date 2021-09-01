package com.insis.defense.cmd.service.implementations;

import com.insis.defense.cmd.domain.Defense;
import com.insis.defense.cmd.domain.DefenseStatus;
import com.insis.defense.cmd.infrastructure.dto.DefenseDTO;
import com.insis.defense.cmd.infrastructure.glue.DefenseGlue;
import com.insis.defense.cmd.infrastructure.rabbit.Producer;
import com.insis.defense.cmd.service.DefenseService;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;


@Service
public class DefenseServiceImpl implements DefenseService {


    //@Autowired
    //DefenseGlue defenseGlue;

    @Autowired
    Producer producer;

    @Override
    public Defense createDefense(Defense defense) throws Exception {
        try{
            producer.sendDefense(defense);
            return defense;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }

    @Override
    public Defense updateDefense(Defense defense, String defenseId) throws Exception {
/*        try{
            DefenseDTO defenseDTO = defenseGlue.findDefenseById(defenseId);
            Optional.ofNullable(defenseDTO);
        }catch (HttpClientErrorException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new IllegalArgumentException();
            }
        }*/

        try{
            producer.updateDefense(defense);
            return defense;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }

    @Override
    public Defense updateDefenseStatus(DefenseStatus status, String id) {
        return null;
    }

    @Override
    public boolean deleteDefense(long id) {
        return false;
    }
}
