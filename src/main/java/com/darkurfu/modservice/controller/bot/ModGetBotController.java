package com.darkurfu.modservice.controller.bot;

import com.darkurfu.modservice.consts.exceptions.HaveNotAccessException;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import com.darkurfu.modservice.service.bot.ModInfoBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bot/v1/mod/get")
public class ModGetBotController {

    private final ModInfoBotService modInfoBotService;

    @Autowired
    public ModGetBotController(ModInfoBotService modInfoBotService){
        this.modInfoBotService = modInfoBotService;
    }


    /**
     * Предоставляет информанию о модераторе по chatId
     *
     * @param chatId header
     * @param modChatId path
     * @return ResponseEntity<Object>
     */
    @GetMapping("/{chat_id}")
    ResponseEntity<Object> getMod(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId,
            @PathVariable("chat_id") String modChatId
            ){
        ResponseEntity<Object> responseEntity;

        try {

            ModeratorInfo moderatorInfo = modInfoBotService.getModInfo(Long.parseLong(chatId), Long.parseLong(modChatId));

            responseEntity = new ResponseEntity<>(moderatorInfo, HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }

    /**
     * Предоставляет информанию о всех модераторах
     *
     * @param chatId header
     * @return ResponseEntity<Object>
     */
    @GetMapping("/")
    ResponseEntity<Object> getMods(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String chatId
    ){
        ResponseEntity<Object> responseEntity;

        try {

            List<ModeratorInfo> moderatorInfo = modInfoBotService.getAllModsInfo(Long.parseLong(chatId));

            responseEntity = new ResponseEntity<>(moderatorInfo ,HttpStatusCode.valueOf(200));

        } catch (HaveNotAccessException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }

}
