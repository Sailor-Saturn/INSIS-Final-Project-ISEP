package com.insis.proposal.cmd.controller.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ProposalResponseDTO {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Schema(description="Proposal id", maxLength=30)
    private String proposalId;

    @NotNull
    @Schema(description="Proposal title", maxLength=20)
    private String title;

    @NotNull
    @Schema(description="Proposal description", maxLength=20)
    private String problem;

    @NotNull
    @Schema(description="Proposal goals", maxLength=20)
    private String goals;

    @Schema(description="List of proposal technologies")
    private List<String> technologies;

    @Schema(description="List of proposal keywords")
    private List<String> keywords;

    @Schema(description="List of proposal approaches")
    private List<String> approaches;

    @NotNull
    @Schema(description="Proponent id", maxLength=30)
    private String proponentId;

    @Schema(description="RUC comment", maxLength=20)
    private String comment;

    @NotNull
    @Schema(description="Proposal status", maxLength=20)
    private String status;

    public ProposalResponseDTO() {
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
