package com.darkurfu.modservice.datamodels.mod;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "moderator_access")
public class ModeratorAccess {
    @Id
    private Long id;


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
