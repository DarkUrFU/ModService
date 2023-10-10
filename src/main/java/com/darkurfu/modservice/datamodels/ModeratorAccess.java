package com.darkurfu.modservice.datamodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "moderator_access")
public class ModeratorAccess {
    @Id
    private Long id;

    @Column(name = "mod_service")
    private short modService;
    @Column(name = "event_service")
    private short eventService;
    protected ModeratorAccess(){}

    public ModeratorAccess(Long id, short modService, short eventService){
        this.id = id;
        this.modService = modService;
        this.eventService = eventService;
    }
}
