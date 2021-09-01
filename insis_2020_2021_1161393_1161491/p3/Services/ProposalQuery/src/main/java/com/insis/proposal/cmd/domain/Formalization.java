package com.insis.proposal.cmd.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Formalization implements Serializable {

    private static final long serialVersionUID = 1L;

    private String formalizationId;

    private String studentId;

    private String proposalId;

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

    private FormalizationStatus formalizationStatus;

    private String advisorId;

    private List<String> reviewersIds;

    private LocalDateTime formalizationTimestamp;

    public Formalization() {
    }

    public String getFormalizationId() {
        return formalizationId;
    }

    public LocalDateTime getFormalizationTimestamp() {
        return formalizationTimestamp;
    }

    public void setFormalizationTimestamp(LocalDateTime formalizationTimestamp) {
        this.formalizationTimestamp = formalizationTimestamp;
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

    public FormalizationStatus getFormalizationStatus() {
        return formalizationStatus;
    }

    public void setFormalizationStatus(FormalizationStatus formalizationStatus) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formalization that = (Formalization) o;
        return internship == that.internship && Objects.equals(formalizationId, that.formalizationId) && Objects.equals(studentId, that.studentId) && Objects.equals(proposalId, that.proposalId) && Objects.equals(contextDescription, that.contextDescription) && Objects.equals(problemDescription, that.problemDescription) && Objects.equals(objectivesDescription, that.objectivesDescription) && Objects.equals(approachOutcome1, that.approachOutcome1) && Objects.equals(approachOutcome2, that.approachOutcome2) && Objects.equals(contextDescriptionComment, that.contextDescriptionComment) && Objects.equals(problemDescriptionComment, that.problemDescriptionComment) && Objects.equals(objectivesDescriptionComment, that.objectivesDescriptionComment) && Objects.equals(approachOutcome1Comment, that.approachOutcome1Comment) && Objects.equals(approachOutcome2Comment, that.approachOutcome2Comment) && formalizationStatus == that.formalizationStatus && Objects.equals(advisorId, that.advisorId) && Objects.equals(reviewersIds, that.reviewersIds) && Objects.equals(formalizationTimestamp, that.formalizationTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formalizationId, studentId, proposalId, contextDescription, problemDescription, objectivesDescription, approachOutcome1, approachOutcome2, contextDescriptionComment, problemDescriptionComment, objectivesDescriptionComment, approachOutcome1Comment, approachOutcome2Comment, internship, formalizationStatus, advisorId, reviewersIds, formalizationTimestamp);
    }
}
