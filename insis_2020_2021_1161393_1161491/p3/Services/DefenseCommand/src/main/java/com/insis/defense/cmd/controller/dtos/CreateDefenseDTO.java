package com.insis.defense.cmd.controller.dtos;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class CreateDefenseDTO {
    @NotNull
    @Schema(description="User Id", maxLength=20)
    private String userId;

    @NotNull
    @Schema(description="Title", maxLength=20)
    private String title;

    @NotNull
    @Schema(description="Defense Status", maxLength=20)
    private String defenseStatus;

    public CreateDefenseDTO() {
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

}
