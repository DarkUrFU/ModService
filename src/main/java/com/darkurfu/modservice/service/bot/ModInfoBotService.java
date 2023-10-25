package com.darkurfu.modservice.service.bot;

import com.darkurfu.modservice.consts.exceptions.HaveNotAccessException;
import com.darkurfu.modservice.datamodels.mod.Moderator;
import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import com.darkurfu.modservice.datamodels.mod.ModeratorAction;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import com.darkurfu.modservice.repository.mod.ModAccessRepository;
import com.darkurfu.modservice.repository.mod.ModActionsRepository;
import com.darkurfu.modservice.repository.mod.ModInfoRepository;
import com.darkurfu.modservice.repository.mod.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModInfoBotService {

    private final ModRepository modRepository;
    private final ModAccessRepository modAccessRepository;
    private final ModInfoRepository modInfoRepository;
    private final ModActionsRepository modActionsRepository;


    @Autowired
    public ModInfoBotService(
            ModRepository modRepository, ModAccessRepository modAccessRepository,
            ModInfoRepository modInfoRepository, ModActionsRepository modActionsRepository
    ){
        this.modRepository = modRepository;
        this.modAccessRepository = modAccessRepository;
        this.modInfoRepository = modInfoRepository;
        this.modActionsRepository = modActionsRepository;
    }


    @Transactional
    public ModeratorInfo getModInfo(Long chatId, Long modChatID) throws HaveNotAccessException {
        Long id = modRepository.getIdByChatId(chatId);

        short modAccess = modAccessRepository.getAccessModServiceFor(id);
        if (modAccess < 2){
            Moderator moderator = modRepository.getReferenceByChatId(modChatID);
            ModeratorAccess moderatorAccess = modAccessRepository.getReferenceById(moderator.getId());


            ModeratorInfo moderatorInfo = new ModeratorInfo(moderator, moderatorAccess);

            modActionsRepository.save(
                    new ModeratorAction(
                            id,
                            "get mod info:\n" + moderatorInfo.toString()
                    )
            );

            return moderatorInfo;
        } else {
            throw new HaveNotAccessException();
        }
    }

    @Transactional
    public List<ModeratorInfo> getAllModsInfo(Long chatId) throws HaveNotAccessException {

        Long id = modRepository.getIdByChatId(chatId);

        short modAccess = modAccessRepository.getAccessModServiceFor(id);
        if (modAccess < 2){
            //Moderator moderator = modRepository.getReferenceByChatId(modChatID);
            //ModeratorAccess moderatorAccess = modAccessRepository.getReferenceById(moderator.getId());

            List<ModeratorInfo> mods = modInfoRepository.findAll();

            //ModeratorInfo moderatorInfo = new ModeratorInfo(moderator, moderatorAccess);

            modActionsRepository.save(
                    new ModeratorAction(
                            id,
                            "get mod info:\n" + mods.toString()
                    )
            );

            return mods;
        } else {
            throw new HaveNotAccessException();
        }
    }
}
