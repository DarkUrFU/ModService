package com.darkurfu.modservice.service.bot;

import com.darkurfu.modservice.consts.Services;
import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.ModeratorAccess;
import com.darkurfu.modservice.repository.ModAccessRepository;
import com.darkurfu.modservice.repository.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModServiceBot {
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;


    public short getServiceAccessFor(Long chatId, short serviceCode) throws NotFindServiceException {
        Services service = Services.getByCode(serviceCode);

        Long id = modRepository.getIdByChatId(chatId);

        return switch (service){
            case ModService -> modAccessRepository.getAccessModServiceFor(id);
            case EventService -> modAccessRepository.getAccessEventServiceFor(id);
        };
    }

    public ModeratorAccess getAllServiceAccessFor(Long chatId) {
        Long id = modRepository.getIdByChatId(chatId);

        return modAccessRepository.getReferenceById(id);
    }
}
