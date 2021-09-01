package com.insis.proposal.cmd.infrastructure.repository;


import com.insis.proposal.cmd.domain.ProposalStatus;
import com.insis.proposal.cmd.infrastructure.daos.ProposalDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<ProposalDAO, String> {

    List<ProposalDAO> findByProposalStatus(ProposalStatus status);

    List<ProposalDAO> findAllByProponentId(String proponentId);
}
