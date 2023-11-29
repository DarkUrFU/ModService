package com.darkurfu.modservice.controller.internal;

import com.darkurfu.modservice.consts.exceptions.HaveNotAccessException;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import com.darkurfu.modservice.service.bot.ModInfoBotService;
import com.darkurfu.modservice.service.internal.ModInfoInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/internal/v1/mod/get")
public class ModGetInternalController {

    private final ModInfoInternalService modInfoInternalService;

    @Autowired
    public ModGetInternalController(ModInfoInternalService modInfoInternalService){
        this.modInfoInternalService = modInfoInternalService;
    }


    /**
     * Предоставляет информанию о модераторе по chatId
     *
     * @param modId path
     * @return ResponseEntity<Object>
     */
    @GetMapping("/{id}")
    ResponseEntity<Object> getMod(
            @PathVariable("id") String modId
            ){
        ResponseEntity<Object> responseEntity;

        try {

            ModeratorInfo moderatorInfo = modInfoInternalService.getModInfo(UUID.fromString(modId));

            responseEntity = new ResponseEntity<>(moderatorInfo, HttpStatusCode.valueOf(200));

        } catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }

    /**
     * Предоставляет информанию о всех модераторах
     *
     * @return ResponseEntity<Object>
     */
    @GetMapping("/")
    ResponseEntity<Object> getMods(
    ){
        ResponseEntity<Object> responseEntity;

        try {

            List<ModeratorInfo> moderatorInfo = modInfoInternalService.getAllModsInfo();

            responseEntity = new ResponseEntity<>(moderatorInfo ,HttpStatusCode.valueOf(200));

        } catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(403));
        }

        return responseEntity;
    }

}
