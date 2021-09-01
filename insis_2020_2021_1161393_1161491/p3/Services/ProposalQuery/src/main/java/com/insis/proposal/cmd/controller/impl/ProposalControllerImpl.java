package com.insis.proposal.cmd.controller.impl;

import com.insis.proposal.cmd.controller.ProposalController;
import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.controller.dtos.ProposalResponseDTO;
import com.insis.proposal.cmd.controller.mapper.ProposalMapper;
import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.service.ProposalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/q/proposals")
public class ProposalControllerImpl implements ProposalController {

    @Autowired
    private ProposalService proposalService;



    public ResponseEntity<?> findById(@Parameter(description = "id of proposal to be searched")
                         @PathVariable String proposalId) {
        try {
            Proposal proposal = proposalService.getProposalById(proposalId);
            ProposalResponseDTO responseDTO = ProposalMapper.domainToDto(proposal);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity<?> getAllProposals(@Parameter(description = "Retrieve only proposals of this status.") @RequestParam(required = false) String proposalStatus) {

        try {
           List<Proposal> proposalList = proposalService.getAllProposals(proposalStatus);
           List<ProposalResponseDTO> responseDTOList = ProposalMapper.domainListToDtoList(proposalList);
            return ResponseEntity.ok(responseDTOList);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> getAllProposalsOfProponent(@Parameter(description = "Retrieve only proposals of this proponent.") @PathVariable String proponentId) {

        try {
            List<Proposal> proposalList = proposalService.getAllProposalsOfProponent(proponentId);
            List<ProposalResponseDTO> responseDTOList = ProposalMapper.domainListToDtoList(proposalList);
            return ResponseEntity.ok(responseDTOList);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
