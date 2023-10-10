package com.darkurfu.modservice.service;

import com.darkurfu.modservice.consts.Services;
import com.darkurfu.modservice.repository.ModAccessRepository;
import com.darkurfu.modservice.repository.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModService {
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;


    public void getServiceAccessFor(String chatId, short service) {
        short access = modAccessRepository.getAccessFor(chatId, Services.get());
    }
}
