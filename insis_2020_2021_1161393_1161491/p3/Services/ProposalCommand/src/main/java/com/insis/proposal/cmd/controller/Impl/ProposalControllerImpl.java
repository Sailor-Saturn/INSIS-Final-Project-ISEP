package com.insis.proposal.cmd.controller.Impl;

import com.insis.proposal.cmd.controller.ProposalController;
import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateProposalDTO;
import com.insis.proposal.cmd.controller.mapper.ProposalMapper;
import com.insis.proposal.cmd.controller.mapper.ProposalStatusMapper;
import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.domain.ProposalStatus;
import com.insis.proposal.cmd.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proposals")
public class ProposalControllerImpl implements ProposalController {

    @Autowired
    private ProposalService proposalService;


    @Override
    public ResponseEntity<?> createProposal(@RequestBody CreateProposalDTO proposalRequest) {
        Proposal proposal = ProposalMapper.fromDtoToDomain(proposalRequest);
        try {
            Proposal reponseProposal = proposalService.createProposal(proposal);
            UpdateProposalDTO responseDTO = ProposalMapper.domainToDto(reponseProposal);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateProposal(@RequestBody UpdateProposalDTO updateProposalDTO, @PathVariable("id") String id) {
        try {
            Proposal proposal = ProposalMapper.requestUpdateDtoToDomain(updateProposalDTO);
            Proposal updatedProposal = proposalService.updateProposal(proposal, id);
            UpdateProposalDTO responseDTO = ProposalMapper.domainToDto(updatedProposal);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> updateProposalStatus(@RequestBody String newProposalStatus, @PathVariable("id") String id) {

        try {
            ProposalStatus status = ProposalStatusMapper.stringToStatus(newProposalStatus);
            Proposal updatedProposal = proposalService.updateProposalStatus(status, id);
            UpdateProposalDTO responseDTO = ProposalMapper.domainToDto(updatedProposal);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> deleteProposal(@PathVariable("id") String id){
        try {
            proposalService.deleteProposal(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
