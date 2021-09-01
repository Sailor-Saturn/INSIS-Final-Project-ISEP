package com.insis.proposal.cmd.service;

import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.FormalizationStatus;

public interface FormalizationService {

    Formalization createFormalization(Formalization formalization, String proposalId) throws Exception;

    Formalization updateFormalization(Formalization formalization, String id, String proposalId) throws Exception;

    Formalization updateFormalizationStatus(FormalizationStatus status, String id) throws Exception;

    void deleteFormalization(String id) throws Exception;
}
