package com.darkurfu.modservice.controller.bot;

import com.darkurfu.modservice.consts.exceptions.HaveNotAccessException;
import com.darkurfu.modservice.datamodels.mod.Moderator;
import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import com.darkurfu.modservice.service.bot.ModEditorBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/common/v1/mod/editor")
public class ModEditorBotController {

    private final ModEditorBotService modEditorBotService;

    @Autowired
    public ModEditorBotController(ModEditorBotService modEditorBotService){
        this.modEditorBotService = modEditorBotService;
    }



    @PostMapping("/create")
    ResponseEntity<Object> createMod(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId,
            @RequestBody ModeratorInfo moderatorInfo
            ){
        ResponseEntity<Object> responseEntity;

        try {

            modEditorBotService.createMod(Long.valueOf(chatId), moderatorInfo);
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }


    @PutMapping("/update_access")
    ResponseEntity<Object> updateModAccess(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId,
            @RequestBody ModeratorAccess moderatorAccess
    ){
        ResponseEntity<Object> responseEntity;


        try {

            modEditorBotService.updateModAccess(Long.valueOf(chatId), moderatorAccess);
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }

    @PutMapping("/update_info")
    ResponseEntity<Object> updateModInfo(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId,
            @RequestBody Moderator moderator
    ){
        ResponseEntity<Object> responseEntity;


        try {

            modEditorBotService.updateModInfo(Long.valueOf(chatId), moderator);
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }
}
