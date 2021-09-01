package com.insis.proposal.cmd.controller.mapper;

import com.insis.proposal.cmd.controller.dtos.CreateFormalizationDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateFormalizationDTO;
import com.insis.proposal.cmd.domain.Formalization;
import com.insis.proposal.cmd.domain.FormalizationStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class FormalizationMapper {

    private FormalizationMapper() {
        //To avoid invalid instantiation
    }

    public static Formalization fromDtoToDomain(CreateFormalizationDTO createFormalizationRequest){

        Formalization newFormalization = new Formalization();
        newFormalization.setFormalizationId(UUID.randomUUID().toString());
        newFormalization.setProposalId(createFormalizationRequest.getProposalId());
        newFormalization.setStudentId(createFormalizationRequest.getStudentId());
        newFormalization.setContextDescription(createFormalizationRequest.getContextDescription());
        newFormalization.setProblemDescription(createFormalizationRequest.getProblemDescription());
        newFormalization.setObjectivesDescription(createFormalizationRequest.getObjectivesDescription());
        newFormalization.setApproachOutcome1(createFormalizationRequest.getApproachOutcome1());
        newFormalization.setApproachOutcome2(createFormalizationRequest.getApproachOutcome2());
        newFormalization.setInternship(createFormalizationRequest.isInternship());
        newFormalization.setFormalizationStatus(FormalizationStatus.FORMALIZATION_STARTED);

        return newFormalization;
    }

    public static Formalization requestUpdateDtoToDomain(UpdateFormalizationDTO updateFormalizationDto){
        Formalization updateFormalization = new Formalization();
        updateFormalization.setFormalizationId(updateFormalizationDto.getFormalizationId());
        updateFormalization.setStudentId(updateFormalizationDto.getStudentId());
        updateFormalization.setContextDescription(updateFormalizationDto.getContextDescription());
        updateFormalization.setProblemDescription(updateFormalizationDto.getProblemDescription());
        updateFormalization.setObjectivesDescription(updateFormalizationDto.getObjectivesDescription());
        updateFormalization.setApproachOutcome1(updateFormalizationDto.getApproachOutcome1());
        updateFormalization.setApproachOutcome2(updateFormalizationDto.getApproachOutcome2());
        updateFormalization.setInternship(updateFormalizationDto.isInternship());
        updateFormalization.setContextDescriptionComment(updateFormalizationDto.getContextDescriptionComment());
        updateFormalization.setProblemDescriptionComment(updateFormalizationDto.getProblemDescriptionComment());
        updateFormalization.setObjectivesDescriptionComment(updateFormalizationDto.getObjectivesDescriptionComment());
        updateFormalization.setApproachOutcome1Comment(updateFormalizationDto.getApproachOutcome1Comment());
        updateFormalization.setApproachOutcome2Comment(updateFormalizationDto.getApproachOutcome2Comment());
        updateFormalization.setFormalizationStatus(FormalizationStatusMapper.stringToStatus(updateFormalizationDto.getFormalizationStatus()));
        updateFormalization.setAdvisorId(updateFormalizationDto.getAdvisorId());
        updateFormalization.setReviewersIds(updateFormalizationDto.getReviewersIds());

        return updateFormalization;
    }

    public static UpdateFormalizationDTO domainToDto(Formalization formalization){
        UpdateFormalizationDTO formalizationDTO = new UpdateFormalizationDTO();
        formalizationDTO.setFormalizationId(formalization.getFormalizationId());
        formalizationDTO.setStudentId(formalization.getStudentId());
        formalizationDTO.setProposalId(formalization.getProposalId());
        formalizationDTO.setContextDescription(formalization.getContextDescription());
        formalizationDTO.setProblemDescription(formalization.getProblemDescription());
        formalizationDTO.setObjectivesDescription(formalization.getObjectivesDescription());
        formalizationDTO.setApproachOutcome1(formalization.getApproachOutcome1());
        formalizationDTO.setApproachOutcome2(formalization.getApproachOutcome2());
        formalizationDTO.setInternship(formalization.isInternship());
        formalizationDTO.setContextDescriptionComment(formalization.getContextDescriptionComment());
        formalizationDTO.setProblemDescriptionComment(formalization.getProblemDescriptionComment());
        formalizationDTO.setObjectivesDescriptionComment(formalization.getObjectivesDescriptionComment());
        formalizationDTO.setApproachOutcome1Comment(formalization.getApproachOutcome1Comment());
        formalizationDTO.setApproachOutcome2Comment(formalization.getApproachOutcome2Comment());
        formalizationDTO.setFormalizationStatus(FormalizationStatusMapper.statusToString(formalization.getFormalizationStatus()));
        formalizationDTO.setAdvisorId(formalization.getAdvisorId());
        formalizationDTO.setReviewersIds(formalization.getReviewersIds());

        return formalizationDTO;
    }

    public static List<UpdateFormalizationDTO> domainListToDtoList(List<Formalization> formalizationList) {

        List<UpdateFormalizationDTO> responseFormalizationList =  new LinkedList<>();
        formalizationList.forEach(formalization -> {
            responseFormalizationList.add(domainToDto(formalization));
        });
        return responseFormalizationList;
    }
}
