package com.insis.proposal.cmd.infrastructure.repository;

import com.insis.proposal.cmd.domain.FormalizationStatus;
import com.insis.proposal.cmd.infrastructure.daos.FormalizationDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormalizationRepository extends JpaRepository<FormalizationDAO, String> {

    List<FormalizationDAO> findByFormalizationStatus(FormalizationStatus status);
}
