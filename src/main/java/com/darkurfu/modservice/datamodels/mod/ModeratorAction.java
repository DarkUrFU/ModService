package com.darkurfu.modservice.datamodels.mod;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity(name = "mod_actions_history")
@Data
public class ModeratorAction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mod_id")
    private Long modId;
    @Lob
    private String description;
    private Timestamp date;

    protected ModeratorAction(){}

    public ModeratorAction(Long modId, String description){
        //this.id = UUID.randomUUID().getMostSignificantBits();
        this.modId = modId;
        this.description = description;
        this.date = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Asia/Yekaterinburg")));
    }

}
