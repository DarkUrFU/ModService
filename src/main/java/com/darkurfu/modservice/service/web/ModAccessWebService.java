package com.darkurfu.modservice.service.web;

import com.darkurfu.modservice.consts.Services;
import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import com.darkurfu.modservice.repository.mod.ModAccessRepository;
import com.darkurfu.modservice.repository.mod.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ModAccessWebService {
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;

    public ModAccessWebService(){

    }

    @Transactional
    public short getServiceAccessFor(UUID id, short serviceCode) throws NotFindServiceException {
        Services service = Services.getByCode(serviceCode);

        return switch (service){
            case ModService -> modAccessRepository.getAccessModServiceFor(id);
            case EventService -> modAccessRepository.getAccessEventServiceFor(id);
        };
    }


    @Transactional
    public ModeratorAccess getAllServiceAccessFor(UUID id) {
        return modAccessRepository.getReferenceById(id);
    }
}
