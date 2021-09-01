package com.insis.proposal.cmd.controller.mapper;

import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.controller.dtos.ProposalResponseDTO;
import com.insis.proposal.cmd.domain.Proposal;

import java.util.LinkedList;
import java.util.List;
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

    public static Proposal requestUpdateDtoToDomain(ProposalResponseDTO proposalResponse){
        
        return new Proposal(proposalResponse.getProponentId(),
                proposalResponse.getTitle(),
                proposalResponse.getProblem(),
                proposalResponse.getGoals(),
                proposalResponse.getTechnologies(),
                proposalResponse.getKeywords(),
                proposalResponse.getApproaches(),
                proposalResponse.getProponentId(),
                proposalResponse.getComment(),
                ProposalStatusMapper.stringToStatus(proposalResponse.getStatus()));
    }

    public static List<ProposalResponseDTO> domainListToDtoList(List<Proposal> proposalList){
        List<ProposalResponseDTO> proposalResponseDTOList = new LinkedList<>();
        proposalList.forEach(proposal -> {
            proposalResponseDTOList.add(domainToDto(proposal));
        });
        return proposalResponseDTOList;
    }


    public static ProposalResponseDTO domainToDto(Proposal proposal){

        ProposalResponseDTO proposalDTO =  new ProposalResponseDTO();
        proposalDTO.setProposalId(proposal.getProposalId());
        proposalDTO.setTitle(proposal.getTitle());
        proposalDTO.setProblem(proposal.getProblem());
        proposalDTO.setGoals(proposal.getGoals());
        proposalDTO.setTechnologies(proposal.getTechnologies());
        proposalDTO.setApproaches(proposal.getApproaches());
        proposalDTO.setKeywords(proposal.getKeywords());
        proposalDTO.setComment(proposal.getComment());
        proposalDTO.setProponentId(proposal.getProponentId());
        proposalDTO.setStatus(ProposalStatusMapper.statusToString(proposal.getProposalStatus()));

        return proposalDTO;
    }
}
