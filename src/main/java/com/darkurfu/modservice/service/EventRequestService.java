package com.darkurfu.modservice.service;

import com.darkurfu.modservice.datamodels.Moderator;
import com.darkurfu.modservice.repository.EventRequestRepository;
import com.darkurfu.modservice.repository.ModAccessRepository;
import com.darkurfu.modservice.repository.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventRequestService {
    @Autowired
    private EventRequestRepository eventRequestRepository;
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;



}
