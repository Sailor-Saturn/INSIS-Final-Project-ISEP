package com.insis.proposal.cmd.service;

import com.insis.proposal.cmd.domain.Formalization;

import java.util.List;

public interface FormalizationService {

    Formalization getFormalizationById(String id);

    List<Formalization> getAllFormalizations(String formalizationStatus);
}
