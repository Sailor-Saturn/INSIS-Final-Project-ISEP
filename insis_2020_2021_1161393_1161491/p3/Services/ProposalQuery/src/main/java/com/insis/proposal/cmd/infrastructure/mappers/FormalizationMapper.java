package com.insis.proposal.cmd.infrastructure.mappers;

import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.infrastructure.daos.FormalizationDAO;

import java.util.LinkedList;
import java.util.List;

public class FormalizationMapper {

    public static FormalizationDAO fromDomainToDAO(Formalization formalization){
        FormalizationDAO formalizationDAO = new FormalizationDAO();
        formalizationDAO.setFormalizationId(formalization.getFormalizationId());
        formalizationDAO.setStudentId(formalization.getStudentId());
        formalizationDAO.setContextDescription(formalization.getContextDescription());
        formalizationDAO.setProblemDescription(formalization.getProblemDescription());
        formalizationDAO.setObjectivesDescription(formalization.getObjectivesDescription());
        formalizationDAO.setApproachOutcome1(formalization.getApproachOutcome1());
        formalizationDAO.setApproachOutcome2(formalization.getApproachOutcome2());
        formalizationDAO.setInternship(formalization.isInternship());
        formalizationDAO.setContextDescriptionComment(formalization.getContextDescriptionComment());
        formalizationDAO.setProblemDescriptionComment(formalization.getProblemDescriptionComment());
        formalizationDAO.setObjectivesDescriptionComment(formalization.getObjectivesDescriptionComment());
        formalizationDAO.setApproachOutcome1Comment(formalization.getApproachOutcome1Comment());
        formalizationDAO.setApproachOutcome2Comment(formalization.getApproachOutcome2Comment());
        formalizationDAO.setFormalizationStatus(formalization.getFormalizationStatus());
        formalizationDAO.setAdvisorId(formalization.getAdvisorId());
        if(formalization.getReviewersIds() == null) {
            formalizationDAO.setReviewersIds(new LinkedList<>());
        }else{
            formalizationDAO.setReviewersIds(formalization.getReviewersIds());
        }
        return formalizationDAO;
    }

    public static Formalization fromDAOToDomain(FormalizationDAO formalizationDAO){
        Formalization formalization = new Formalization();
        formalization.setFormalizationId(formalizationDAO.getFormalizationId());
        formalization.setStudentId(formalizationDAO.getStudentId());
        formalization.setProposalId(formalizationDAO.getProposal().getProposalId());
        formalization.setContextDescription(formalizationDAO.getContextDescription());
        formalization.setProblemDescription(formalizationDAO.getProblemDescription());
        formalization.setObjectivesDescription(formalizationDAO.getObjectivesDescription());
        formalization.setApproachOutcome1(formalizationDAO.getApproachOutcome1());
        formalization.setApproachOutcome2(formalizationDAO.getApproachOutcome2());
        formalization.setInternship(formalizationDAO.isInternship());
        formalization.setContextDescriptionComment(formalizationDAO.getContextDescriptionComment());
        formalization.setProblemDescriptionComment(formalizationDAO.getProblemDescriptionComment());
        formalization.setObjectivesDescriptionComment(formalizationDAO.getObjectivesDescriptionComment());
        formalization.setApproachOutcome1Comment(formalizationDAO.getApproachOutcome1Comment());
        formalization.setApproachOutcome2Comment(formalizationDAO.getApproachOutcome2Comment());
        formalization.setFormalizationStatus(formalizationDAO.getFormalizationStatus());
        formalization.setAdvisorId(formalizationDAO.getAdvisorId());
        formalization.setReviewersIds(formalizationDAO.getReviewersIds());
        formalization.setFormalizationTimestamp(formalizationDAO.getFormalizationTimestamp());
        return formalization;
    }

    public static List<Formalization> fromDAOToDomainList(List<FormalizationDAO> formalizationEntities){
        List<Formalization> formalizationsList = new LinkedList<>();
        formalizationEntities.forEach(formalizationDAO -> {
            formalizationsList.add(fromDAOToDomain(formalizationDAO));
        });
        return formalizationsList;
    }

}
