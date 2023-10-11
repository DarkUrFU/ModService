package com.darkurfu.modservice.controller.bot;

import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.ModeratorAccess;
import com.darkurfu.modservice.service.bot.ModServiceBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot/mod")
public class ModControllerBot {

    @Autowired
    private ModServiceBot modServiceBot;

    @GetMapping("/get_access/{chat_id}/{service}")
    ResponseEntity<Object> getAccess(
            @PathVariable("chat_id") Long chatId,
            @PathVariable short service
    ){
        ResponseEntity<Object> responseEntity;

        try {
            int access = modServiceBot.getServiceAccessFor(chatId, service);

            responseEntity = new ResponseEntity<>(access ,HttpStatusCode.valueOf(200));

        } catch (NotFindServiceException e){

            responseEntity = new ResponseEntity<>("нет такого сервиса", HttpStatusCode.valueOf(404));
        }

        return responseEntity;
    }


    @GetMapping("/get_access/{chat_id}")
    ResponseEntity<Object> getAllAccess(
            @PathVariable("chat_id") Long chatId
    ){
        ResponseEntity<Object> responseEntity;

        try {
            ModeratorAccess access = modServiceBot.getAllServiceAccessFor(chatId);

            responseEntity = new ResponseEntity<>(access ,HttpStatusCode.valueOf(200));

        } catch (Exception e){

            responseEntity = new ResponseEntity<>("Пользователь не найден", HttpStatusCode.valueOf(404));
        }

        return responseEntity;
    }
}
