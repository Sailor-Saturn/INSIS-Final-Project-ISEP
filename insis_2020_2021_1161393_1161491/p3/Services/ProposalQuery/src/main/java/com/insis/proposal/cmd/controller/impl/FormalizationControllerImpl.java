package com.insis.proposal.cmd.controller.impl;

import com.insis.proposal.cmd.controller.FormalizationController;
import com.insis.proposal.cmd.controller.dtos.ProposalResponseDTO;
import com.insis.proposal.cmd.controller.dtos.ResponseFormalizationDTO;
import com.insis.proposal.cmd.controller.mapper.FormalizationMapper;
import com.insis.proposal.cmd.controller.mapper.ProposalMapper;
import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.service.FormalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/q/formalizations")
public class FormalizationControllerImpl implements FormalizationController {

    @Autowired
    private FormalizationService formalizationService;


    @Override
    public ResponseEntity<?> getAllFormalizations(String formalizationStatus) {

        try {
            List<Formalization> formalizationList = formalizationService.getAllFormalizations(formalizationStatus);
            List<ResponseFormalizationDTO> responseDTOList = FormalizationMapper.domainListToDtoList(formalizationList);
            return ResponseEntity.ok(responseDTOList);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> findFormalizationById(String id) {
        try {
            Formalization formalization =  formalizationService.getFormalizationById(id);
            ResponseFormalizationDTO responseDTO = FormalizationMapper.domainToDto(formalization);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}
