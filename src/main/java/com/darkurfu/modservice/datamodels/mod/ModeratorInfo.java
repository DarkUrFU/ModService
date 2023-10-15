package com.darkurfu.modservice.datamodels.mod;

import lombok.Data;


@Data
public class ModeratorInfo {

    private Long id;
    private Long chatId;
    private String tgName;

    private short modService;
    private short eventService;

    protected ModeratorInfo(){}

    public ModeratorInfo(Long chatId, String tgName, short modService, short eventService) {
        this.chatId = chatId;
        this.tgName = tgName;
        this.modService = modService;
        this.eventService = eventService;
    }

    public ModeratorInfo(Long id, Long chatId, String tgName, short modService, short eventService) {
        this.id = id;
        this.chatId = chatId;
        this.tgName = tgName;
        this.modService = modService;
        this.eventService = eventService;
    }
}




