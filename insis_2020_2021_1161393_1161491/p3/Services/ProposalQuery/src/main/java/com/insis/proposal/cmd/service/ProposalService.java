package com.insis.proposal.cmd.service;

import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
import com.insis.proposal.cmd.domain.Proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {
    
    Proposal getProposalById(String proposalId);

    List<Proposal> getAllProposals(String proposalStatus);

    List<Proposal> getAllProposalsOfProponent(String proponentId);
}
