package com.insis.proposal.cmd.controller.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateFormalizationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Schema(description="Student id", maxLength=30)
    private String studentId;

    @NotNull
    @Schema(description="Proposal id", maxLength=30)
    private String proposalId;

    @NotNull
    @Schema(description="Context description", maxLength=20)
    private String contextDescription;

    @NotNull
    @Schema(description="Problem description", maxLength=20)
    private String problemDescription;

    @NotNull
    @Schema(description="Objectives description", maxLength=20)
    private String objectivesDescription;

    @NotNull
    @Schema(description="Approach description to achieve outcome 1", maxLength=20)
    private String approachOutcome1;

    @NotNull
    @Schema(description="Approach description to achieve outcome 2", maxLength=20)
    private String approachOutcome2;

    @NotNull
    @Schema(description="Is it an Internship?", maxLength=10)
    private boolean internship;

    public CreateFormalizationDTO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getContextDescription() {
        return contextDescription;
    }

    public void setContextDescription(String contextDescription) {
        this.contextDescription = contextDescription;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getObjectivesDescription() {
        return objectivesDescription;
    }

    public void setObjectivesDescription(String objectivesDescription) {
        this.objectivesDescription = objectivesDescription;
    }

    public String getApproachOutcome1() {
        return approachOutcome1;
    }

    public void setApproachOutcome1(String approachOutcome1) {
        this.approachOutcome1 = approachOutcome1;
    }

    public String getApproachOutcome2() {
        return approachOutcome2;
    }

    public void setApproachOutcome2(String approachOutcome2) {
        this.approachOutcome2 = approachOutcome2;
    }

    public boolean isInternship() {
        return internship;
    }

    public void setInternship(boolean internship) {
        this.internship = internship;
    }
}
