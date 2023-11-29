package com.darkurfu.modservice.datamodels.mod;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "moderator")
public class Moderator {
    @Id
    private UUID id;

    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "tg_name")
    private String tgName;

    protected Moderator(){}

    public Moderator(Long chatId, String tgName){
        this.id = UUID.randomUUID();
        this.chatId = chatId;
        this.tgName = tgName;
    }

    public Moderator(ModeratorInfo moderatorInfo) {
        this.id = UUID.randomUUID();
        this.chatId = moderatorInfo.getChatId();
        this.tgName = moderatorInfo.getTgName();
    }
}
