package com.insis.defense.cmd.infrastructure;

import com.insis.defense.cmd.controller.mapper.DefenseStatusMapper;
import com.insis.defense.cmd.domain.Defense;
import com.insis.defense.cmd.infrastructure.daos.DefenseDAO;

import java.util.LinkedList;
import java.util.List;

public class DefenseMapper {

    public static Defense fromDAOToDomain(DefenseDAO defenseDAO){
        Defense defense = new Defense();

        defense.setDefenseId(defenseDAO.getDefenseId());
        defense.setDefenseStatus(DefenseStatusMapper.stringToStatus(defenseDAO.getDefenseStatus()));
        defense.setTitle(defenseDAO.getTitle());
        defense.setUserId(defenseDAO.getstudentId());
        defense.setJuryId(defenseDAO.getJuryId());

        return defense;
    }

    public static DefenseDAO fromDomainToDAO(Defense defense){
        DefenseDAO defenseDAO = new DefenseDAO();
        defenseDAO.setDefenseId(defense.getDefenseId());
        defenseDAO.setDefenseStatus(DefenseStatusMapper.statusToString(defense.getDefenseStatus()));
        defenseDAO.setJuryId(defense.getJuryId());
        defenseDAO.setTitle(defense.getTitle());
        defenseDAO.setStudentId(defense.getUserId());

        return defenseDAO;
    }

    public static List<Defense> fromDAOToDomainList(List<DefenseDAO> list) {
        List<Defense> defenseList = new LinkedList<>();
        list.forEach(defenseDAO -> {
            defenseList.add(fromDAOToDomain(defenseDAO));
        });
        return defenseList;
    }
}
