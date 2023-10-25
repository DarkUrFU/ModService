package com.darkurfu.modservice.service.bot;

import com.darkurfu.modservice.consts.Services;
import com.darkurfu.modservice.consts.exceptions.NotFindServiceException;
import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import com.darkurfu.modservice.repository.mod.ModAccessRepository;
import com.darkurfu.modservice.repository.mod.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModAccessBotService {
    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ModAccessRepository modAccessRepository;



    @Transactional
    public short getServiceAccessFor(Long chatId, short serviceCode) throws NotFindServiceException {
        Services service = Services.getByCode(serviceCode);

        Long id = modRepository.getIdByChatId(chatId);

        return switch (service){
            case ModService -> modAccessRepository.getAccessModServiceFor(id);
            case EventService -> modAccessRepository.getAccessEventServiceFor(id);
        };
    }

    @Transactional
    public ModeratorAccess getAllServiceAccessFor(Long chatId) {
        Long id = modRepository.getIdByChatId(chatId);

        return modAccessRepository.getReferenceById(id);
    }
}
