package com.darkurfu.modservice.consts;

import java.util.HashMap;
import java.util.Map;

public class Services {
    private static final HashMap<Integer, String> map = new HashMap<>(Map.of(0,"mod_service", 1,"event_service") );

    static String getById(int id){
        return map.get(id);
    }
}
