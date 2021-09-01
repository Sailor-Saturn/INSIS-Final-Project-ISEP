package com.insis.proposal.cmd.controller.Impl;

import com.insis.proposal.cmd.controller.FormalizationController;
import com.insis.proposal.cmd.controller.dtos.CreateFormalizationDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateFormalizationDTO;
import com.insis.proposal.cmd.controller.mapper.FormalizationMapper;
import com.insis.proposal.cmd.controller.mapper.FormalizationStatusMapper;
import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.FormalizationStatus;
import com.insis.proposal.cmd.service.FormalizationService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formalizations")
public class FormalizationControllerImpl implements FormalizationController {

    @Autowired
    private FormalizationService formalizationService;

    @Override
    public ResponseEntity<?> createFormalization(@RequestBody CreateFormalizationDTO formalizationRequest) {
        Formalization formalization = FormalizationMapper.fromDtoToDomain(formalizationRequest);
        try {
            formalizationService.createFormalization(formalization, formalizationRequest.getProposalId());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateFormalization(@RequestBody UpdateFormalizationDTO updateFormalizationDTO, @PathVariable("id") String id) {
        try {
            Formalization formalization = FormalizationMapper.requestUpdateDtoToDomain(updateFormalizationDTO);
            Formalization updatedFormalization = formalizationService.updateFormalization(formalization, id, updateFormalizationDTO.getProposalId());
            UpdateFormalizationDTO updatedFormalizationDto = FormalizationMapper.domainToDto(updatedFormalization);
            return ResponseEntity.ok(updatedFormalizationDto);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> updateFormalizationStatus(@RequestBody String newFormalizationStatus, @PathVariable("id") String id) {
        try {
            FormalizationStatus status = FormalizationStatusMapper.stringToStatus(newFormalizationStatus);
            Formalization updatedFormalization = formalizationService.updateFormalizationStatus(status, id);
            UpdateFormalizationDTO updatedFormalizationDto = FormalizationMapper.domainToDto(updatedFormalization);
            return ResponseEntity.ok(updatedFormalizationDto);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> deleteFormalization(@Parameter(description = "id of formalization to be deleted") @PathVariable("id") String id){
        try {
            formalizationService.deleteFormalization(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
