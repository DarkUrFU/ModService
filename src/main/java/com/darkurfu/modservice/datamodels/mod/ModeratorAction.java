package com.darkurfu.modservice.datamodels.mod;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "mod_actions_history")
@Data
public class ModeratorAction {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    private String description;

    protected ModeratorAction(){}

    public ModeratorAction(Long userId, String description){
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.userId = userId;
        this.description = description;
    }

}
