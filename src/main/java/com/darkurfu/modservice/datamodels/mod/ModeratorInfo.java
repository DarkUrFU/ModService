package com.darkurfu.modservice.datamodels.mod;

import jakarta.persistence.*;
import lombok.Data;
import org.yaml.snakeyaml.tokens.Token;

import java.util.UUID;

@Data
@Entity
@Table(name = "moderator")
@SecondaryTable(name = "moderator_access", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
//@SecondaryTable(name = "moderator_access", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class ModeratorInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "tg_name")
    private String tgName;


    @Column(name = "mod_service", table = "moderator_access", nullable=true)
    private Short modService;
    @Column(name = "event_service", table = "moderator_access", nullable=true)
    private Short eventService;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "moderator_access", referencedColumnName = "id")
    //private ModeratorAccess moderatorAccess;


    protected ModeratorInfo(){}

    public ModeratorInfo(Long chatId, String tgName, Short modService, Short eventService) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.chatId = chatId;
        this.tgName = tgName;
        this.eventService = eventService;
        this.modService = modService;
        //this.moderatorAccess = moderatorAccess;
    }

    public ModeratorInfo(Long id, Long chatId, String tgName, Short modService, Short eventService) {
        this.id = id;
        this.chatId = chatId;
        this.tgName = tgName;
        this.eventService = eventService;
        this.modService = modService;
        //this.moderatorAccess = moderatorAccess;
    }

    public ModeratorInfo(Moderator moderator, ModeratorAccess moderatorAccess) {
        this.id = moderator.getId();
        this.chatId = moderator.getChatId();
        this.tgName = moderator.getTgName();
        this.eventService = moderatorAccess.getEventService();
        this.modService = moderatorAccess.getModService();
        //this.moderatorAccess = moderatorAccess;
    }
}
