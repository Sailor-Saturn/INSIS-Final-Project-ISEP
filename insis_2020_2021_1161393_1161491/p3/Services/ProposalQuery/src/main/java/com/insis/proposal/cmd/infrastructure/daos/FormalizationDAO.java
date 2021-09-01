package com.insis.proposal.cmd.infrastructure.daos;

import com.insis.proposal.cmd.domain.FormalizationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "formalization")
public class FormalizationDAO {

    @Id
    @Column(name = "id")
    private String formalizationId;

    private String studentId;

    @OneToOne(mappedBy = "formalization")
    private ProposalDAO proposal;

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

    @ElementCollection
    private List<String> reviewersIds;

    @Column(name = "formalization_timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime formalizationTimestamp;

    public FormalizationDAO() {
    }

    public String getFormalizationId() {
        return formalizationId;
    }

    public void setFormalizationId(String id) {
        this.formalizationId = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ProposalDAO getProposal() {
        return proposal;
    }

    public void setProposal(ProposalDAO proposal) {
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

    public LocalDateTime getFormalizationTimestamp() {
        return formalizationTimestamp;
    }

    public void setFormalizationTimestamp(LocalDateTime formalizationTimestamp) {
        this.formalizationTimestamp = formalizationTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormalizationDAO that = (FormalizationDAO) o;
        return internship == that.internship && Objects.equals(formalizationId, that.formalizationId) && Objects.equals(studentId, that.studentId) && Objects.equals(proposal, that.proposal) && Objects.equals(contextDescription, that.contextDescription) && Objects.equals(problemDescription, that.problemDescription) && Objects.equals(objectivesDescription, that.objectivesDescription) && Objects.equals(approachOutcome1, that.approachOutcome1) && Objects.equals(approachOutcome2, that.approachOutcome2) && Objects.equals(contextDescriptionComment, that.contextDescriptionComment) && Objects.equals(problemDescriptionComment, that.problemDescriptionComment) && Objects.equals(objectivesDescriptionComment, that.objectivesDescriptionComment) && Objects.equals(approachOutcome1Comment, that.approachOutcome1Comment) && Objects.equals(approachOutcome2Comment, that.approachOutcome2Comment) && formalizationStatus == that.formalizationStatus && Objects.equals(advisorId, that.advisorId) && Objects.equals(reviewersIds, that.reviewersIds) && Objects.equals(formalizationTimestamp, that.formalizationTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formalizationId, studentId, proposal, contextDescription, problemDescription, objectivesDescription, approachOutcome1, approachOutcome2, contextDescriptionComment, problemDescriptionComment, objectivesDescriptionComment, approachOutcome1Comment, approachOutcome2Comment, internship, formalizationStatus, advisorId, reviewersIds, formalizationTimestamp);
    }

}
