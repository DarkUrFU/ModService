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
@RequestMapping("/api/bot/v1/mod/edit")
public class ModEditorBotController {

    private final ModEditorBotService modEditorBotService;

    @Autowired
    public ModEditorBotController(ModEditorBotService modEditorBotService){
        this.modEditorBotService = modEditorBotService;
    }


    /**
     * Создаёт нового модератора
     *
     * @param chatId header
     * @param moderatorInfo body
     * @return ResponseEntity<Object>
     */
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

    /**
     * Изменяет доступ к сервисам для модератора
     *
     * @param chatId header
     * @param moderatorAccess body
     * @return ResponseEntity<Object>
     */
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

    /**
     * Изменяет основную информацию о модераторе
     *
     * @param chatId header
     * @param moderator body
     * @return ResponseEntity<Object>
     */
    @PutMapping("/update_mod")
    ResponseEntity<Object> updateMod(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId,
            @RequestBody Moderator moderator
    ){
        ResponseEntity<Object> responseEntity;


        try {

            modEditorBotService.updateMod(Long.valueOf(chatId), moderator);
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }
}
