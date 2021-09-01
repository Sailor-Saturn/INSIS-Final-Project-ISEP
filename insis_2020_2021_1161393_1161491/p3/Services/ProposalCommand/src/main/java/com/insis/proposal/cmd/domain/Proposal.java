package com.insis.proposal.cmd.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    private com.insis.proposal.cmd.domain.ProposalStatus proposalStatus;

    private LocalDateTime proposalTimestamp;

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
        this.proposalStatus = com.insis.proposal.cmd.domain.ProposalStatus.ANALYSIS;
    }

    public Proposal(String proposalId, String title, String problem, String goals, List<String> technologies,
                    List<String> keywords, List<String> approaches, String proponentId, String comment, com.insis.proposal.cmd.domain.ProposalStatus proposalStatus) {
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

    public com.insis.proposal.cmd.domain.ProposalStatus getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(com.insis.proposal.cmd.domain.ProposalStatus proposalStatus) {
        this.proposalStatus = proposalStatus;
    }
}
