package com.insis.proposal.cmd.service.implementations;

import com.insis.proposal.cmd.controller.mapper.FormalizationStatusMapper;
import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.FormalizationStatus;
import com.insis.proposal.cmd.infrastructure.daos.FormalizationDAO;
import com.insis.proposal.cmd.infrastructure.daos.ProposalDAO;
import com.insis.proposal.cmd.infrastructure.mappers.FormalizationMapper;
import com.insis.proposal.cmd.infrastructure.repository.FormalizationRepository;
import com.insis.proposal.cmd.infrastructure.repository.ProposalRepository;
import com.insis.proposal.cmd.service.FormalizationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class FormalizationServiceImpl implements FormalizationService {

    @Autowired
    FormalizationRepository formalizationRepository;

    @Autowired
    ProposalRepository proposalRepository;

    @RabbitListener(queues = "${insis.rabbitmq.formalization.created.queue}")
    public void consumeMessageFromCreateProposalQueue(Formalization formalization) {

        saveFormalization(formalization);
    }

    @RabbitListener(queues = "${insis.rabbitmq.formalization.updated.queue}")
    public void consumeMessageFromUpdateProposalQueue(Formalization formalization) {
        saveFormalization(formalization);
    }

    @RabbitListener(queues = "${insis.rabbitmq.formalization.delete.queue}")
    public void consumeMessageFromDeleteProposalQueue(String id) {
        deleteFormalization(id);
    }

    @Transactional
    public void deleteFormalization(String id){
        formalizationRepository.deleteById(id);
    }

    @Transactional
    public void saveFormalization(Formalization formalization){
        Optional<ProposalDAO> optional = proposalRepository.findById(formalization.getProposalId());
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        FormalizationDAO formalizationDAO = FormalizationMapper.fromDomainToDAO(formalization);
        ProposalDAO proposalDAO = optional.get();
        formalizationDAO.setProposal(optional.get());
        proposalDAO.setFormalization(formalizationDAO);
        proposalRepository.save(proposalDAO);
        formalizationRepository.save(formalizationDAO);
    }


    @Override
    public Formalization getFormalizationById(String id) {
        Optional<FormalizationDAO> optionalFormalization = formalizationRepository.findById(id);
        if (!optionalFormalization.isPresent()) {
            throw new IllegalArgumentException("There's no formalization with the associated id");
        }
        return FormalizationMapper.fromDAOToDomain(optionalFormalization.get());
    }

    @Override
    public List<Formalization> getAllFormalizations(String formalizationStatus) {

        if(formalizationStatus == null){
            List<FormalizationDAO> list = formalizationRepository.findAll();
            return FormalizationMapper.fromDAOToDomainList(list);
        }
        FormalizationStatus status = FormalizationStatusMapper.stringToStatus(formalizationStatus);
        if(status.equals(FormalizationStatus.ERROR)){
            throw new IllegalArgumentException("The status inserted is not valid.");
        }else{
            List<FormalizationDAO> list = formalizationRepository.findByFormalizationStatus(status);
            return FormalizationMapper.fromDAOToDomainList(list);
        }
    }
}
