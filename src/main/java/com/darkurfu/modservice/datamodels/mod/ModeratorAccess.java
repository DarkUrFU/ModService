package com.darkurfu.modservice.datamodels.mod;

import jakarta.persistence.*;
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

    public ModeratorAccess(Long id, ModeratorInfo moderatorInfo) {
        this.id = id;
        this.modService = moderatorInfo.getModService();
        this.eventService = moderatorInfo.getEventService();
    }

    public ModeratorAccess(ModeratorInfo moderatorInfo) {
        this.modService = moderatorInfo.getModService();
        this.eventService = moderatorInfo.getEventService();
    }
}
