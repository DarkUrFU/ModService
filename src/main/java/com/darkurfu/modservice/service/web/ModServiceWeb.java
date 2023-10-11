package com.darkurfu.modservice.service.web;

import com.darkurfu.modservice.consts.Services;
import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.ModeratorAccess;
import com.darkurfu.modservice.repository.ModAccessRepository;
import com.darkurfu.modservice.repository.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModServiceWeb {
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;


    public short getServiceAccessFor(Long id, short serviceCode) throws NotFindServiceException {
        Services service = Services.getByCode(serviceCode);

        return switch (service){
            case ModService -> modAccessRepository.getAccessModServiceFor(id);
            case EventService -> modAccessRepository.getAccessEventServiceFor(id);
        };
    }

    public ModeratorAccess getAllServiceAccessFor(Long id) {
        return modAccessRepository.getReferenceById(id);
    }
}
