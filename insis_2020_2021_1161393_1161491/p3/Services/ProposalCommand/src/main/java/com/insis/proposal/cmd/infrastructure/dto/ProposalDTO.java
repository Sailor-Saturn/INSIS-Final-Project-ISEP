package com.insis.proposal.cmd.infrastructure.dto;

import java.io.Serializable;
import java.util.List;

public class ProposalDTO {

    private String proposalId;

    private String title;

    private String problem;

    private String goals;

    private List<String> technologies;

    private List<String> keywords;

    private List<String> approaches;

    private String proponentId;

    private String comment;

    private String status;

    public ProposalDTO() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
