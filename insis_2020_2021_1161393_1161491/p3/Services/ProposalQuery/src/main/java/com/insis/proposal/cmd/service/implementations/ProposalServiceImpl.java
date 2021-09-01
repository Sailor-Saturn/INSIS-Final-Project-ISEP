package com.insis.proposal.cmd.service.implementations;

import com.insis.proposal.cmd.controller.mapper.ProposalStatusMapper;
import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.domain.ProposalStatus;
import com.insis.proposal.cmd.infrastructure.daos.ProposalDAO;
import com.insis.proposal.cmd.infrastructure.mappers.ProposalMapper;
import com.insis.proposal.cmd.infrastructure.repository.ProposalRepository;
import com.insis.proposal.cmd.service.ProposalService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Component
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    ProposalRepository proposalRepository;

    @RabbitListener(queues = "${insis.rabbitmq.proposal.created.queue}")
    public void consumeMessageFromCreateProposalQueue(Proposal proposal) {

        ProposalDAO proposalDAO = ProposalMapper.fromDomainToDAO(proposal);
        saveProposal(proposalDAO);
    }

    @Transactional
    public void saveProposal(ProposalDAO proposalDAO){
        proposalRepository.save(proposalDAO);
    }

    @RabbitListener(queues = "${insis.rabbitmq.proposal.updated.queue}")
    public void consumeMessageFromUpdateProposalQueue(Proposal proposal) {

        ProposalDAO proposalDAO = ProposalMapper.fromDomainToDAO(proposal);
        saveProposal(proposalDAO);
    }

    @RabbitListener(queues = "${insis.rabbitmq.proposal.delete.queue}")
    public void consumeMessageFromDeleteProposalQueue(String proposalId) {
       deleteProposal(proposalId);
    }

    @Transactional
    public void deleteProposal(String proposalId){
        proposalRepository.deleteById(proposalId);
    }

    @Override
    public Proposal getProposalById(String proposalId) {
        Optional<ProposalDAO> optionalProposal = proposalRepository.findById(proposalId);
        if (!optionalProposal.isPresent()) {
            throw new IllegalArgumentException("There's no proposal with the associated id");
        }
        return ProposalMapper.fromDAOToDomain(optionalProposal.get());
    }

    @Override
    public List<Proposal> getAllProposals(String proposalStatus) {

        if(proposalStatus == null){
            List<ProposalDAO> list = proposalRepository.findAll();
            return ProposalMapper.fromDAOToDomainList(list);
        }
        ProposalStatus status = ProposalStatusMapper.stringToStatus(proposalStatus);
        if(status.equals(ProposalStatus.ERROR)){
            throw new IllegalArgumentException("The status inserted is not valid.");
        }else{
            List<ProposalDAO> list = proposalRepository.findByProposalStatus(status);
            return ProposalMapper.fromDAOToDomainList(list);
        }
    }

    @Override
    public List<Proposal> getAllProposalsOfProponent(String proponentId) {
        List<ProposalDAO> list = proposalRepository.findAllByProponentId(proponentId);
        return ProposalMapper.fromDAOToDomainList(list);
    }

}
