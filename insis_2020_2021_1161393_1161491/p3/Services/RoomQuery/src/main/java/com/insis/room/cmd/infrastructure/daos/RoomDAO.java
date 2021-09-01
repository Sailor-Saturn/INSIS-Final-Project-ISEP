package com.insis.room.cmd.infrastructure.daos;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "room")
public class RoomDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String roomId;

/*    @ElementCollection
    private List<ScheduleDAO> schedule;*/

    protected RoomDAO() {
        // for Hibernate
    }

    public RoomDAO(String roomId) {
        this.roomId = roomId;
    }


}
