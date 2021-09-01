package com.insis.defense.cmd.controller.mapper;

import com.insis.defense.cmd.domain.DefenseStatus;

public class DefenseStatusMapper {

    private DefenseStatusMapper() {
    }

    public static DefenseStatus stringToStatus(String status) {
        switch(status){
            case "REPORT_SUBMITTED":
                return DefenseStatus.REPORT_SUBMITTED;
            case "JURY_INVITED":
                return DefenseStatus.JURY_INVITED;
            case "JURY_REJECTED":
                return DefenseStatus.JURY_REJECTED;
            case "JURY_CHOSEN":
                return DefenseStatus.JURY_CHOSEN;
            case "DATE_PLACE_CHOSEN":
                return DefenseStatus.DATE_PLACE_CHOSEN;
            case "GRADED":
                return DefenseStatus.GRADED;
            default:
                return DefenseStatus.ERROR;
        }
    }

    public static String statusToString(DefenseStatus defenseStatus) {
        switch(defenseStatus){
            case REPORT_SUBMITTED:
                return "REPORT_SUBMITTED";
            case JURY_INVITED:
                return "JURY_INVITED";
            case JURY_REJECTED:
                return "JURY_REJECTED";
            case JURY_CHOSEN:
                return "JURY_CHOSE";
            case DATE_PLACE_CHOSEN:
                return "DATE_PLACE_CHOSEN";
            case GRADED:
                return "GRADED";
            default:
                return "ERROR";
        }

    }
}
