package com.darkurfu.modservice.datamodels.mod;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "moderator_access")
public class ModeratorAccess {
    @Id
    private UUID id;


    @Column(name = "mod_service")
    private Short modService;
    @Column(name = "event_service")
    private Short eventService;
    @Column(name = "auth_service")
    private Short authService;
    @Column(name = "user_service")
    private Short userService;
    @Column(name = "team_service")
    private Short teamService;
    @Column(name = "base_service")
    private Short baseService;

    protected ModeratorAccess(){}

    public ModeratorAccess(UUID id, short modService, short eventService){
        this.id = id;
        this.modService = modService;
        this.eventService = eventService;
    }

    public ModeratorAccess(UUID id, ModeratorInfo moderatorInfo) {
        this.id = id;
        this.modService = moderatorInfo.getModService();
        this.eventService = moderatorInfo.getEventService();
    }

    public ModeratorAccess(ModeratorInfo moderatorInfo) {
        this.modService = moderatorInfo.getModService();
        this.eventService = moderatorInfo.getEventService();
    }
}
