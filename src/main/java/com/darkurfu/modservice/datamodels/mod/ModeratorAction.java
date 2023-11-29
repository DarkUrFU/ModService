package com.darkurfu.modservice.datamodels.mod;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Entity(name = "mod_actions_history")
@Data
public class ModeratorAction {

    @Id
    private UUID id;

    @Column(name = "mod_id")
    private UUID modId;
    @Lob
    private String description;
    private Timestamp date;

    protected ModeratorAction(){}

    public ModeratorAction(UUID modId, String description){
        this.id = UUID.randomUUID();
        this.modId = modId;
        this.description = description;
        this.date = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Asia/Yekaterinburg")));
    }

}
