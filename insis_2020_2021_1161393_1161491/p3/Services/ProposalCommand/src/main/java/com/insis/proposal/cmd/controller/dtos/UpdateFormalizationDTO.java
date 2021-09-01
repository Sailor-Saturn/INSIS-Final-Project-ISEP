package com.insis.proposal.cmd.controller.dtos;

import com.insis.proposal.cmd.domain.Proposal;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class UpdateFormalizationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Schema(description="Formalization id", maxLength=30)
    private String formalizationId;

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

    @Schema(description="Context description comment", maxLength=20)
    private String contextDescriptionComment;

    @Schema(description="Problem description comment", maxLength=20)
    private String problemDescriptionComment;

    @Schema(description="Objectives description comment", maxLength=20)
    private String objectivesDescriptionComment;

    @Schema(description="Approach description to achieve outcome 1 comment", maxLength=20)
    private String approachOutcome1Comment;

    @Schema(description="Approach description to achieve outcome 2 comment", maxLength=20)
    private String approachOutcome2Comment;

    @NotNull
    @Schema(description="Formalization status", maxLength=20)
    private String formalizationStatus;

    @NotNull
    @Schema(description="Advisor id", maxLength=30)
    private String advisorId;

    @Schema(description="List of reviewers ids")
    private List<String> reviewersIds;

    public UpdateFormalizationDTO() {
    }

    public String getFormalizationId() {
        return formalizationId;
    }

    public void setFormalizationId(String formalizationId) {
        this.formalizationId = formalizationId;
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

    public String getContextDescriptionComment() {
        return contextDescriptionComment;
    }

    public void setContextDescriptionComment(String contextDescriptionComment) {
        this.contextDescriptionComment = contextDescriptionComment;
    }

    public String getProblemDescriptionComment() {
        return problemDescriptionComment;
    }

    public void setProblemDescriptionComment(String problemDescriptionComment) {
        this.problemDescriptionComment = problemDescriptionComment;
    }

    public String getObjectivesDescriptionComment() {
        return objectivesDescriptionComment;
    }

    public void setObjectivesDescriptionComment(String objectivesDescriptionComment) {
        this.objectivesDescriptionComment = objectivesDescriptionComment;
    }

    public String getApproachOutcome1Comment() {
        return approachOutcome1Comment;
    }

    public void setApproachOutcome1Comment(String approachOutcome1Comment) {
        this.approachOutcome1Comment = approachOutcome1Comment;
    }

    public String getApproachOutcome2Comment() {
        return approachOutcome2Comment;
    }

    public void setApproachOutcome2Comment(String approachOutcome2Comment) {
        this.approachOutcome2Comment = approachOutcome2Comment;
    }

    public String getFormalizationStatus() {
        return formalizationStatus;
    }

    public void setFormalizationStatus(String formalizationStatus) {
        this.formalizationStatus = formalizationStatus;
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public List<String> getReviewersIds() {
        return reviewersIds;
    }

    public void setReviewersIds(List<String> reviewersIds) {
        this.reviewersIds = reviewersIds;
    }
}
