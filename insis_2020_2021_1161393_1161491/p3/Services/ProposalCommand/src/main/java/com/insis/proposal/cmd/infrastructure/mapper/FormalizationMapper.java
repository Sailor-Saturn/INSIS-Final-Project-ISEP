package com.insis.proposal.cmd.infrastructure.mapper;

import com.insis.proposal.cmd.controller.mapper.FormalizationStatusMapper;
import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.infrastructure.dto.FormalizationDTO;

public class FormalizationMapper {

    public static FormalizationDTO fromDomainToDTO (Formalization formalization, String proposalId){
        FormalizationDTO result = new FormalizationDTO();
        result.setFormalizationId(formalization.getFormalizationId());
        result.setStudentId(formalization.getStudentId());
        result.setProposal(proposalId);
        result.setContextDescription(formalization.getContextDescription());
        result.setProblemDescription(formalization.getProblemDescription());
        result.setObjectivesDescription(formalization.getObjectivesDescription());
        result.setApproachOutcome1(formalization.getApproachOutcome1());
        result.setApproachOutcome2(formalization.getApproachOutcome2());
        result.setInternship(formalization.isInternship());
        result.setContextDescriptionComment(formalization.getContextDescriptionComment());
        result.setProblemDescriptionComment(formalization.getProblemDescriptionComment());
        result.setObjectivesDescriptionComment(formalization.getObjectivesDescriptionComment());
        result.setApproachOutcome1Comment(formalization.getApproachOutcome1Comment());
        result.setApproachOutcome2Comment(formalization.getApproachOutcome2Comment());
        result.setFormalizationStatus(FormalizationStatusMapper.statusToString(formalization.getFormalizationStatus()));
        result.setAdvisorId(formalization.getAdvisorId());
        result.setReviewersIds(formalization.getReviewersIds());

        return result;
    }
}
