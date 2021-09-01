package com.insis.proposal.cmd.service.implementations;

import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.domain.ProposalStatus;
import com.insis.proposal.cmd.infrastructure.dto.ProposalDTO;
import com.insis.proposal.cmd.infrastructure.glue.ProposalGlue;
import com.insis.proposal.cmd.infrastructure.rabbit.Producer;
import com.insis.proposal.cmd.service.ProposalService;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;


@Service
public class ProposalServiceImpl implements ProposalService {


    @Autowired
    ProposalGlue proposalGlue;

    @Autowired
    Producer producer;


    @Override
    public Proposal createProposal(Proposal proposal) throws Exception {

        try{
            producer.sendProposal(proposal);
            return proposal;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }


    @Override
    public Proposal updateProposal(Proposal proposal, String proposalId) throws Exception {
        //TODO
        // make get to proposal query in order to check if proposal exists
        System.out.println("cheguei aqui");
        try{
            ProposalDTO proposalDto = proposalGlue.findById(proposalId);
    //        Optional.ofNullable(proposalDto);
            System.out.println(proposalDto);

        }catch (HttpClientErrorException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new IllegalArgumentException();
            }
        }
        System.out.println("encontrou com sucesso");
        //if 404 - return 404
        // se existir - fazer alterações necessarias
       // validateProponent(proposal);
/*        try{
            producer.updateProposal(proposal);
            return proposal;
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }*/
        // send message to rabbitMQ - insis.rabbitmq.proposal.updated.queue
        return proposal;
    }

    private void validateProponent(Proposal proposal) {
        // Proponentes com 3 propostas rejeitadas ou canceladas, ficam inativos durante 4 meses
        // se for o caso enviar mensagem para a queue - insis.rabbitmq.three.proposals.proponent.exchange
    }

    @Override
    public Proposal updateProposalStatus(ProposalStatus status, String id) {

        if(status.equals(ProposalStatus.ERROR)){
            throw new IllegalArgumentException("The status inserted is not valid.");
        }else{
            //TODO
            // make get to proposal query in order to check if proposal exists
            //if 404 - return 404
            // se existir - fazer alterações necessarias
            // TODO make get to proposal query in order getAllProposalsOfProponent
            //validateProponent(proposal);

            // send message to rabbitMQ - insis.rabbitmq.proposal.updated.queue
        }

        return null;
    }

    @Override
    public void deleteProposal(String id) throws Exception {
        //TODO
        // make get to proposal query in order to check if proposal exists
        //if 404 - return 404
        try{
            producer.deleteProposal(id);
        }catch (AmqpException rabbitException){
            throw new Exception("Rabbit error!");
        }
    }


}
