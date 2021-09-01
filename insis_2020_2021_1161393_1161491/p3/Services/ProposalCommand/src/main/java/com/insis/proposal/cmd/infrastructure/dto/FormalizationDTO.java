package com.insis.proposal.cmd.infrastructure.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class FormalizationDTO implements Serializable {

    private String formalizationId;

    private String studentId;

    private String proposal;

    private String contextDescription;

    private String problemDescription;

    private String objectivesDescription;

    private String approachOutcome1;

    private String approachOutcome2;

    private String contextDescriptionComment;

    private String problemDescriptionComment;

    private String objectivesDescriptionComment;

    private String approachOutcome1Comment;

    private String approachOutcome2Comment;

    private boolean internship;

    private String formalizationStatus;

    private String advisorId;

    private List<String> reviewersIds;

    private LocalDateTime formalizationTimestamp;

    public FormalizationDTO() {
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

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
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

    public boolean isInternship() {
        return internship;
    }

    public void setInternship(boolean internship) {
        this.internship = internship;
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

    public LocalDateTime getFormalizationTimestamp() {
        return formalizationTimestamp;
    }

    public void setFormalizationTimestamp(LocalDateTime formalizationTimestamp) {
        this.formalizationTimestamp = formalizationTimestamp;
    }
}
