package com.insis.proposal.cmd.service;

import com.insis.proposal.cmd.domain.Proposal;
import com.insis.proposal.cmd.domain.ProposalStatus;
import org.springframework.stereotype.Service;

@Service
public interface ProposalService {

    Proposal createProposal(Proposal proposal) throws Exception;

    Proposal updateProposal(Proposal proposal, String id) throws Exception;

    Proposal updateProposalStatus(ProposalStatus status, String id);

    void deleteProposal(String id) throws Exception;
}
