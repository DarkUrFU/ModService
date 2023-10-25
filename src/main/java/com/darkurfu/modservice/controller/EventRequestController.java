package com.darkurfu.modservice.controller;

import com.darkurfu.modservice.service.EventRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/event")
public class EventRequestController {
    @Autowired
    private EventRequestService eventRequestService;

}
