package com.insis.proposal.cmd.controller.mapper;

import com.insis.proposal.cmd.domain.ProposalStatus;

public class ProposalStatusMapper {

    private ProposalStatusMapper() {
        //To avoid invalid instantiation
    }

    public static ProposalStatus stringToStatus(String status){
        switch (status){
            case "ANALYSIS":
                return ProposalStatus.ANALYSIS;
            case "REJECTED":
                return ProposalStatus.REJECTED;
            case "CANCELED":
                return ProposalStatus.CANCELED;
            case "ACCEPTED":
                return ProposalStatus.ACCEPTED;
            default:
                return ProposalStatus.ERROR;
        }
    }

    public static String statusToString (ProposalStatus status){
        switch(status){
            case ANALYSIS:
                return "ANALYSIS";
            case REJECTED:
                return "REJECTED";
            case CANCELED:
                return "CANCELED";
            case ACCEPTED:
                return "ACCEPTED";
            default:
                return "ERROR";
        }
    }
}
