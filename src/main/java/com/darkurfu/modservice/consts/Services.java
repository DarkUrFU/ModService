package com.darkurfu.modservice.consts;

import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import lombok.Getter;

public enum Services {
    ModService((short) 0, "ma.modService"),
    EventService((short) 1, "ma.eventService");


    @Getter
    final private short code;
    @Getter
    final private String dbName;


    Services(short code, String dbName){
        this.code = code;
        this.dbName = dbName;
    }

    public static Services getByCode(short code) throws NotFindServiceException {

        return switch (code) {
            case (0) -> ModService;
            case (1) -> EventService;
            default -> throw new NotFindServiceException();
        };

    }
}
