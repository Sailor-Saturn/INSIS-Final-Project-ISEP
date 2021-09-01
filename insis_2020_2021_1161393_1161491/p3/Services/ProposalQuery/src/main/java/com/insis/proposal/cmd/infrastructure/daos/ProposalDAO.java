package com.insis.proposal.cmd.infrastructure.daos;

import com.insis.proposal.cmd.domain.ProposalStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "proposal")
public class ProposalDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String proposalId;

    private String title;

    private String problem;

    private String goals;

    @ElementCollection
    private List<String> technologies;

    @ElementCollection
    private List<String> keywords;

    @ElementCollection
    private List<String> approaches;

    private String proponentId;

    private String comment;

    private ProposalStatus proposalStatus;

    @Column(name = "proposal_timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime proposalTimestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formalization_id", referencedColumnName = "id", nullable = true)
    private FormalizationDAO formalization;

    public ProposalDAO() {
        // for Hibernate
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getApproaches() {
        return approaches;
    }

    public void setApproaches(List<String> approaches) {
        this.approaches = approaches;
    }

    public String getProponentId() {
        return proponentId;
    }

    public void setProponentId(String userId) {
        this.proponentId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ProposalStatus getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(ProposalStatus proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public LocalDateTime getProposalTimestamp() {
        return proposalTimestamp;
    }

    public void setProposalTimestamp(LocalDateTime localDateTime) {
        this.proposalTimestamp = localDateTime;
    }

    public FormalizationDAO getFormalization() {
        return formalization;
    }

    public void setFormalization(FormalizationDAO formalization) {
        this.formalization = formalization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProposalDAO that = (ProposalDAO) o;
        return Objects.equals(proposalId, that.proposalId) && Objects.equals(title, that.title) && Objects.equals(problem, that.problem) && Objects.equals(goals, that.goals) && Objects.equals(technologies, that.technologies) && Objects.equals(keywords, that.keywords) && Objects.equals(approaches, that.approaches) && Objects.equals(proponentId, that.proponentId) && Objects.equals(comment, that.comment) && proposalStatus == that.proposalStatus && Objects.equals(proposalTimestamp, that.proposalTimestamp) && Objects.equals(formalization, that.formalization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proposalId, title, problem, goals, technologies, keywords, approaches, proponentId, comment, proposalStatus, proposalTimestamp, formalization);
    }
}
