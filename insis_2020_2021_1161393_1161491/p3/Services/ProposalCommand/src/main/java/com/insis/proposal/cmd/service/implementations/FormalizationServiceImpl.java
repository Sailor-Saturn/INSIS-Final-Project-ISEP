package com.insis.proposal.cmd.service.implementations;

import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.FormalizationStatus;
import com.insis.proposal.cmd.infrastructure.dto.FormalizationDTO;
import com.insis.proposal.cmd.infrastructure.mapper.FormalizationMapper;
import com.insis.proposal.cmd.infrastructure.rabbit.Producer;
import com.insis.proposal.cmd.service.FormalizationService;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormalizationServiceImpl implements FormalizationService {

    @Autowired
    Producer producer;


    @Override
    public Formalization createFormalization(Formalization formalization, String proposalId) throws Exception {
        //TODO
        // make get to proposal query in order to check if proposal exists
        //if 404 - return 404    throw new IllegalArgumentException("There's no proposal with the indicated id");
        //
        // se existir - fazer alterações necessarias
        try{
            producer.sendFormalization(formalization);
            return formalization;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }

    @Override
    public Formalization updateFormalization(Formalization formalization, String id, String proposalId) throws Exception {
        //TODO
        // make get to proposal query in order to check if formalization exists
        //if 404 - return 404    throw new IllegalArgumentException("There's no proposal with the indicated id");
        //
        // se existir - fazer alterações necessarias
        // result = request by proposalId
        //formalization.setProposal(result);
        try{
            producer.updateFormalization(formalization);
            return formalization;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }

    @Override
    public Formalization updateFormalizationStatus(FormalizationStatus status, String id) throws Exception {
        if (status.equals(FormalizationStatus.ERROR)) {
            throw new IllegalArgumentException("The status inserted is not valid.");
        } else {
         /*    try{
                //TODO
                // make get to proposal query in order to check if formalization exists
                //if 404 - return 404    throw new IllegalArgumentException("There's no proposal with the indicated id");
                //
                // se existir - fazer alterações necessarias

               producer.updateFormalization(formalization);
                return formalization;
            }catch (AmqpException rabbitException){
                throw new Exception("Rabbit error!");
            }

        }*/
            return null;
        }
    }

        @Override
        public void deleteFormalization(String id) throws Exception {
            //TODO
            // make get to proposal query in order to check if formalization exists
            //if 404 - return 404
            try{
                producer.deleteFormalization(id);
            }catch (AmqpException rabbitException){
                throw new Exception("Rabbit error!");
            }
        }
    }
