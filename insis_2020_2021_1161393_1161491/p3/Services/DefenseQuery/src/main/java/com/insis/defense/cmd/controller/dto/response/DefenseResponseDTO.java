package com.insis.defense.cmd.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class DefenseResponseDTO {
    @NotNull
    @Schema(description="Defense Id", maxLength=20)
    private String defenseId;

    @NotNull
    @Schema(description="User Id", maxLength=20)
    private String userId;

    @NotNull
    @Schema(description="Title", maxLength=20)
    private String title;

    @NotNull
    @Schema(description="Defense Status", maxLength=20)
    private String defenseStatus;

    @NotNull
    @Schema(description = "Jury Id", maxLength = 20)
    private String juryId;

    public DefenseResponseDTO() {
    }

    public String getDefenseId() {
        return defenseId;
    }

    public void setDefenseId(String defenseId) {
        this.defenseId = defenseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefenseStatus() {
        return defenseStatus;
    }

    public void setDefenseStatus(String defenseStatus) {
        this.defenseStatus = defenseStatus;
    }

    public String getJuryId() {
        return juryId;
    }

    public void setJuryId(String juryId) {
        this.juryId = juryId;
    }
}
