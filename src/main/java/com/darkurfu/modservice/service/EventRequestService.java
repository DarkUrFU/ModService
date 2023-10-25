package com.darkurfu.modservice.service;

import com.darkurfu.modservice.repository.event.EventRequestRepository;
import com.darkurfu.modservice.repository.mod.ModAccessRepository;
import com.darkurfu.modservice.repository.mod.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRequestService {
    @Autowired
    private EventRequestRepository eventRequestRepository;
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;



}
