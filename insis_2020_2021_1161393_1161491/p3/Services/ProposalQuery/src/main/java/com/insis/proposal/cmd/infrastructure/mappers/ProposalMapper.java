package com.insis.proposal.cmd.infrastructure.mappers;

import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.domain.ProposalStatus;
import com.insis.proposal.cmd.infrastructure.daos.ProposalDAO;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ProposalMapper {

    private ProposalMapper() {
        //To avoid invalid instantiation
    }

    public static ProposalDAO fromDomainToDAO(Proposal proposal){
        ProposalDAO proposalDAO = new ProposalDAO();
        proposalDAO.setProposalId(proposal.getProposalId());
        proposalDAO.setTitle(proposal.getTitle());
        proposalDAO.setProblem(proposal.getProblem());
        proposalDAO.setGoals(proposal.getGoals());
        proposalDAO.setTechnologies(proposal.getTechnologies());
        proposalDAO.setKeywords(proposal.getKeywords());
        proposalDAO.setApproaches(proposal.getApproaches());
        proposalDAO.setProponentId(proposal.getProponentId());
        proposalDAO.setComment(proposal.getComment());
        proposalDAO.setProposalStatus(proposal.getProposalStatus());
        if(proposal.getFormalization() != null){
            proposalDAO.setFormalization(FormalizationMapper.fromDomainToDAO(proposal.getFormalization()));
        }
        return proposalDAO;
    }

    public static ProposalDAO fromCreateDtoToDomain(CreateProposalDTO createProposalRequest){
        ProposalDAO proposalDAO = new ProposalDAO();
        proposalDAO.setProposalId(UUID.randomUUID().toString());
        proposalDAO.setTitle(createProposalRequest.getTitle());
        proposalDAO.setProblem(createProposalRequest.getProblem());
        proposalDAO.setGoals(createProposalRequest.getGoals());
        proposalDAO.setTechnologies(createProposalRequest.getTechnologies());
        proposalDAO.setKeywords(createProposalRequest.getKeywords());
        proposalDAO.setApproaches(createProposalRequest.getApproaches());
        proposalDAO.setProponentId(createProposalRequest.getProponentId());
        proposalDAO.setProposalStatus(ProposalStatus.ANALYSIS);

        return proposalDAO;
    }

    public static List<Proposal> fromDAOToDomainList(List<ProposalDAO> proposalEntities){
        List<Proposal> proposalsList = new LinkedList<>();
        proposalEntities.forEach(proposalDAO -> {
            proposalsList.add(fromDAOToDomain(proposalDAO));
        });
        return proposalsList;
    }

    public static Proposal fromDAOToDomain(ProposalDAO proposalDAO){
        Proposal proposal = new Proposal();
        proposal.setProposalId(proposalDAO.getProposalId());
        proposal.setTitle(proposalDAO.getTitle());
        proposal.setProblem(proposalDAO.getProblem());
        proposal.setGoals(proposalDAO.getGoals());
        proposal.setTechnologies(proposalDAO.getTechnologies());
        proposal.setKeywords(proposalDAO.getKeywords());
        proposal.setApproaches(proposalDAO.getApproaches());
        proposal.setProponentId(proposalDAO.getProponentId());
        proposal.setComment(proposalDAO.getComment());
        proposal.setProposalStatus(proposalDAO.getProposalStatus());
        proposal.setProposalTimestamp(proposalDAO.getProposalTimestamp());
        proposal.setProponentId(proposalDAO.getProponentId());
        if(proposalDAO.getFormalization() != null){
            proposal.setFormalization(FormalizationMapper.fromDAOToDomain(proposalDAO.getFormalization()));
        }
        return proposal;
    }
}
