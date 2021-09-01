package com.insis.proposal.cmd.controller.mapper;

import com.insis.proposal.cmd.domain.FormalizationStatus;

public class FormalizationStatusMapper {

    private FormalizationStatusMapper() {
        //To avoid invalid instantiation
    }

    public static FormalizationStatus stringToStatus(String status){
        switch (status){
            case "FORMALIZATION_STARTED":
                return FormalizationStatus.FORMALIZATION_STARTED;
            case "FORMALIZATION_ACCEPTED_ADVISOR":
                return FormalizationStatus.FORMALIZATION_ACCEPTED_ADVISOR;
            case "FORMALIZATION_REJECTED_ADVISOR":
                return FormalizationStatus.FORMALIZATION_REJECTED_ADVISOR;
            case "FORMALIZATION_REFACTORED":
                return FormalizationStatus.FORMALIZATION_REFACTORED;
            case "REVIEWERS_REJECTED":
                return FormalizationStatus.REVIEWERS_REJECTED;
            case "REVIEWERS_CHOSEN":
                return FormalizationStatus.REVIEWERS_CHOSEN;
            case "REVIEWERS_ACCEPTED":
                return FormalizationStatus.REVIEWERS_ACCEPTED;
            case "FORMALIZATION_REJECTED":
                return FormalizationStatus.FORMALIZATION_REJECTED;
            case "FORMALIZATION_ACCEPTED":
                return FormalizationStatus.FORMALIZATION_ACCEPTED;
            default:
                return FormalizationStatus.ERROR;
        }
    }

    public static String statusToString (FormalizationStatus status){
        switch(status){
            case FORMALIZATION_STARTED:
                return "FORMALIZATION_STARTED";
            case FORMALIZATION_ACCEPTED_ADVISOR:
                return "FORMALIZATION_ACCEPTED_ADVISOR";
            case FORMALIZATION_REJECTED_ADVISOR:
                return "FORMALIZATION_REJECTED_ADVISOR";
            case FORMALIZATION_REFACTORED:
                return "FORMALIZATION_REFACTORED";
            case REVIEWERS_REJECTED:
                return "REVIEWERS_REJECTED";
            case REVIEWERS_CHOSEN:
                return "REVIEWERS_CHOSEN";
            case REVIEWERS_ACCEPTED:
                return "REVIEWERS_ACCEPTED";
            case FORMALIZATION_REJECTED:
                return "FORMALIZATION_REJECTED";
            case FORMALIZATION_ACCEPTED:
                return "FORMALIZATION_ACCEPTED";
            default:
                return "ERROR";
        }
    }
}
