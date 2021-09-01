package com.insis.defense.cmd.service.implementations;

import com.insis.defense.cmd.controller.mapper.DefenseStatusMapper;
import com.insis.defense.cmd.domain.Defense;
import com.insis.defense.cmd.domain.DefenseStatus;
import com.insis.defense.cmd.infrastructure.DefenseMapper;
import com.insis.defense.cmd.infrastructure.daos.DefenseDAO;
import com.insis.defense.cmd.infrastructure.repository.DefenseRepository;
import com.insis.defense.cmd.service.DefenseService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Component
public class DefenseServiceImpl implements DefenseService {

    @Autowired
    DefenseRepository defenseRepository;

    @RabbitListener(queues = "${insis.rabbitmq.defense.created.queue}")
    public void consumeMessageFromQueue(Defense defense) {
        DefenseDAO defenseDAO = DefenseMapper.fromDomainToDAO(defense);
        saveDefense(defenseDAO);
    }

    @Transactional
    public void saveDefense(DefenseDAO defenseDAO){
        defenseRepository.save(defenseDAO);
    }

    @RabbitListener(queues = "${insis.rabbitmq.defense.updated.queue}")
    public void consumeMessageFromUpdateDefenseQueue(Defense defense) {

        DefenseDAO defenseDAO = DefenseMapper.fromDomainToDAO(defense);
        saveDefense(defenseDAO);
    }

    @RabbitListener(queues = "${insis.rabbitmq.defense.delete.queue}")
    public void consumeMessageFromDeleteProposalQueue(String defenseId) {
        deleteDefense(defenseId);
    }

    @Transactional
    public void deleteDefense(String defenseId){
        defenseRepository.deleteById(defenseId);
    }

    @Override
    public Defense getDefenseById(String defenseId) {
        Optional<DefenseDAO> optionalDefense = defenseRepository.findById(defenseId);
        if (!optionalDefense.isPresent()) {
            throw new IllegalArgumentException("There's no defense with the associated id");
        }
        return DefenseMapper.fromDAOToDomain(optionalDefense.get());
    }

    @Override
    public List<Defense> getAllDefenses(String defenseStatus) {
        if(defenseStatus == null){
            List<DefenseDAO> list = defenseRepository.findAll();
            return DefenseMapper.fromDAOToDomainList(list);
        }

        DefenseStatus status = DefenseStatusMapper.stringToStatus(defenseStatus);
        if(status.equals(DefenseStatus.ERROR)){
            throw new IllegalArgumentException("The status inserted is not valid.");
        }else{
            List<DefenseDAO> list = defenseRepository.findByDefenseStatus(status);
            return DefenseMapper.fromDAOToDomainList(list);
        }
    }

    @Override
    public Defense createDefense(Defense defense) throws Exception {
        DefenseDAO defenseDAO = DefenseMapper.fromDomainToDAO(defense);
        DefenseDAO de  = defenseRepository.save(defenseDAO);
        return DefenseMapper.fromDAOToDomain(de);
    }
}
