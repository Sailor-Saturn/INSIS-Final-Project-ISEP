package com.insis.proposal.cmd.domain;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String proposalId;

    private String title;

    private String problem;

    private String goals;

    private List<String> technologies;

    private List<String> keywords;

    private List<String> approaches;

    private String proponentId;

    private String comment;

    private ProposalStatus proposalStatus;

    private LocalDateTime proposalTimestamp;

    private Formalization formalization;

    public Proposal() {
    }

    public Proposal(String proposalId, String title, String problem, String goals, List<String> technologies,
                    List<String> keywords, List<String> approaches, String proponentId) {
        this.proposalId = proposalId;
        this.title = title;
        this.problem = problem;
        this.goals = goals;
        this.technologies = technologies;
        this.keywords = keywords;
        this.approaches = approaches;
        this.proponentId = proponentId;
        this.proposalStatus = ProposalStatus.ANALYSIS;
    }

    public Proposal(String proposalId, String title, String problem, String goals, List<String> technologies,
                    List<String> keywords, List<String> approaches, String proponentId, String comment, ProposalStatus proposalStatus) {
        this.proposalId = proposalId;
        this.title = title;
        this.problem = problem;
        this.goals = goals;
        this.technologies = technologies;
        this.keywords = keywords;
        this.approaches = approaches;
        this.proponentId = proponentId;
        this.comment = comment;
        this.proposalStatus = proposalStatus;
    }

    public Formalization getFormalization() {
        return formalization;
    }

    public void setFormalization(Formalization formalization) {
        this.formalization = formalization;
    }

    public LocalDateTime getProposalTimestamp() {
        return proposalTimestamp;
    }

    public void setProposalTimestamp(LocalDateTime proposalTimestamp) {
        this.proposalTimestamp = proposalTimestamp;
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

    public void setProponentId(String proponentId) {
        this.proponentId = proponentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposal proposal = (Proposal) o;
        return Objects.equals(proposalId, proposal.proposalId) && Objects.equals(title, proposal.title) && Objects.equals(problem, proposal.problem) && Objects.equals(goals, proposal.goals) && Objects.equals(technologies, proposal.technologies) && Objects.equals(keywords, proposal.keywords) && Objects.equals(approaches, proposal.approaches) && Objects.equals(proponentId, proposal.proponentId) && Objects.equals(comment, proposal.comment) && proposalStatus == proposal.proposalStatus && Objects.equals(proposalTimestamp, proposal.proposalTimestamp) && Objects.equals(formalization, proposal.formalization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proposalId, title, problem, goals, technologies, keywords, approaches, proponentId, comment, proposalStatus, proposalTimestamp, formalization);
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "proposalId='" + proposalId + '\'' +
                ", title='" + title + '\'' +
                ", problem='" + problem + '\'' +
                ", goals='" + goals + '\'' +
                ", technologies=" + technologies +
                ", keywords=" + keywords +
                ", approaches=" + approaches +
                ", proponentId='" + proponentId + '\'' +
                ", comment='" + comment + '\'' +
                ", proposalStatus=" + proposalStatus +
                ", proposalTimestamp=" + proposalTimestamp +
                ", formalization=" + formalization +
                '}';
    }
}
