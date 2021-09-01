package com.insis.defense.cmd.infrastructure.repository;


import com.insis.defense.cmd.domain.DefenseStatus;
import com.insis.defense.cmd.infrastructure.daos.DefenseDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefenseRepository extends JpaRepository<DefenseDAO, String> {
    List<DefenseDAO> findByDefenseStatus(DefenseStatus defenseStatus);


}
