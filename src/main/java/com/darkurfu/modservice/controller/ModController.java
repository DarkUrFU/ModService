package com.darkurfu.modservice.controller;

import com.darkurfu.modservice.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mod")
public class ModController {

    @Autowired
    private ModService modService;

    @GetMapping("/get_access/{service}")
    private int getAccess(
            @RequestHeader("chatId") String chatId,
            @PathVariable short service
    ){
        modService.getServiceAccessFor(chatId, service);

        return 0;
    }
}
