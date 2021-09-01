package com.insis.proposal.cmd.controller.mapper;

import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateProposalDTO;
import com.insis.proposal.cmd.domain.Proposal;

import java.util.UUID;

public class ProposalMapper {

    private ProposalMapper() {
        //To avoid invalid instantiation
    }

    public static Proposal fromDtoToDomain(CreateProposalDTO createProposalRequest){

       return new Proposal(UUID.randomUUID().toString(),
                createProposalRequest.getTitle(),
                createProposalRequest.getProblem(),
                createProposalRequest.getGoals(),
                createProposalRequest.getTechnologies(),
                createProposalRequest.getKeywords(),
                createProposalRequest.getApproaches(),
                createProposalRequest.getProponentId());
    }

    public static Proposal requestUpdateDtoToDomain(UpdateProposalDTO updateProposal){

        return new Proposal(updateProposal.getProponentId(),
                updateProposal.getTitle(),
                updateProposal.getProblem(),
                updateProposal.getGoals(),
                updateProposal.getTechnologies(),
                updateProposal.getKeywords(),
                updateProposal.getApproaches(),
                updateProposal.getProponentId(),
                updateProposal.getComment(),
                com.insis.proposal.cmd.controller.mapper.ProposalStatusMapper.stringToStatus(updateProposal.getStatus()));
    }


    public static UpdateProposalDTO domainToDto(Proposal proposal){

        UpdateProposalDTO proposalDTO =  new UpdateProposalDTO();
        proposalDTO.setProposalId(proposal.getProposalId());
        proposalDTO.setTitle(proposal.getTitle());
        proposalDTO.setProblem(proposal.getProblem());
        proposalDTO.setGoals(proposal.getGoals());
        proposalDTO.setTechnologies(proposal.getTechnologies());
        proposalDTO.setApproaches(proposal.getApproaches());
        proposalDTO.setKeywords(proposal.getKeywords());
        proposalDTO.setComment(proposal.getComment());
        proposalDTO.setProponentId(proposal.getProponentId());
        proposalDTO.setStatus(com.insis.proposal.cmd.controller.mapper.ProposalStatusMapper.statusToString(proposal.getProposalStatus()));

        return proposalDTO;
    }
}
