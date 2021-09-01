package com.insis.room.cmd.infrastructure.repository;


import com.insis.room.cmd.infrastructure.daos.RoomDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomDAO, String> {


}
