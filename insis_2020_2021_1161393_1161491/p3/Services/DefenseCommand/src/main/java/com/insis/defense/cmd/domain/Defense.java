package com.insis.defense.cmd.domain;

import java.io.Serializable;

public class Defense implements Serializable {

    private String defenseId;
    private String userId;
    private String title;
    private DefenseStatus defenseStatus;
    private String juryId;

    public Defense(String defenseId, String userId, String title, DefenseStatus defenseStatus, String juryId) {
        this.defenseId = defenseId;
        this.userId = userId;
        this.title = title;
        this.defenseStatus = defenseStatus;
        this.juryId = juryId;
    }

    public Defense(String defenseId, String userId, String title, DefenseStatus defenseStatus) {
        this.defenseId = defenseId;
        this.userId = userId;
        this.title = title;
        this.defenseStatus = defenseStatus;
    }

    public Defense() {

    }

    public String getJuryId() {
        return juryId;
    }

    public void setJuryId(String juryId) {
        this.juryId = juryId;
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

    public DefenseStatus getDefenseStatus() {
        return defenseStatus;
    }

    public void setDefenseStatus(DefenseStatus defenseStatus) {
        this.defenseStatus = defenseStatus;
    }

    @Override
    public String toString() {
        return "Defense{" +
                "defenseId='" + defenseId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", defenseStatus=" + defenseStatus +
                '}';
    }
}
