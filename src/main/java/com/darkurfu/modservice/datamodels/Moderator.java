package com.darkurfu.modservice.datamodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "moderator")
public class Moderator {
    @Id
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "tg_name")
    private String tgName;

    protected Moderator(){}

    protected Moderator(Long chatId, String tgName){
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.chatId = chatId;
        this.tgName = tgName;
    }

}
