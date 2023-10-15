package com.darkurfu.modservice.controller.web;

import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import com.darkurfu.modservice.service.web.ModAccessWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/v1/mod")
public class ModAccessWebController {

    @Autowired
    private ModAccessWebService modAccessWebService;

    @GetMapping("/get_access/{id}/{service}")
    ResponseEntity<Object> getAccess(
            @PathVariable("id") Long id,
            @PathVariable short service
    ){
        ResponseEntity<Object> responseEntity;

        try {
            int access = modAccessWebService.getServiceAccessFor(id, service);

            responseEntity = new ResponseEntity<>(access ,HttpStatusCode.valueOf(200));

        } catch (NotFindServiceException e){

            responseEntity = new ResponseEntity<>("нет такого сервиса", HttpStatusCode.valueOf(400));
        } catch (Exception e){
            responseEntity = new ResponseEntity<>("пользователь не найден", HttpStatusCode.valueOf(404));
        }

        return responseEntity;
    }

    @GetMapping("/get_access/{id}")
    ResponseEntity<Object> getAllAccess(
            @PathVariable("id") Long id
    ){
        ResponseEntity<Object> responseEntity;

        try {
            ModeratorAccess access = modAccessWebService.getAllServiceAccessFor(id);

            responseEntity = new ResponseEntity<>(access ,HttpStatusCode.valueOf(200));

        } catch (Exception e){

            responseEntity = new ResponseEntity<>("Пользователь не найден", HttpStatusCode.valueOf(404));
        }

        return responseEntity;
    }
}
