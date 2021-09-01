package com.insis.defense.cmd.infrastructure.daos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "defense")
public class DefenseDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String defenseId;

    private String studentId;

    private String title;

    private String defenseStatus;

    private String juryId;


    public DefenseDAO() {
        // for Hibernate
    }

    public String getDefenseId() {
        return defenseId;
    }

    public void setDefenseId(String defenseId) {
        this.defenseId = defenseId;
    }

    public String getstudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefenseDAO)) return false;
        DefenseDAO that = (DefenseDAO) o;
        return Objects.equals(defenseId, that.defenseId) && Objects.equals(studentId, that.studentId) && Objects.equals(title, that.title) && Objects.equals(defenseStatus, that.defenseStatus) && Objects.equals(juryId, that.juryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defenseId, studentId, title, defenseStatus, juryId);
    }

    @Override
    public String toString() {
        return "DefenseDAO{" +
                "defenseId='" + defenseId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", title='" + title + '\'' +
                ", defenseStatus='" + defenseStatus + '\'' +
                ", juryId='" + juryId + '\'' +
                '}';
    }
}
