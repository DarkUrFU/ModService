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

import java.util.UUID;

@Service
public class ModEditorBotService {


    private final ModInfoRepository modInfoRepository;
    private final ModRepository modRepository;
    private final ModAccessRepository modAccessRepository;
    private final ModActionsRepository modActionsRepository;


    @Autowired
    public ModEditorBotService(
            ModInfoRepository modInfoRepository, ModRepository modRepository,
            ModAccessRepository modAccessRepository, ModActionsRepository modActionsRepository
    ){
        this.modInfoRepository = modInfoRepository;
        this.modRepository = modRepository;
        this.modAccessRepository = modAccessRepository;
        this.modActionsRepository = modActionsRepository;
    }


    @Transactional
    public void createMod(Long chatId, ModeratorInfo moderatorInfo) throws HaveNotAccessException {
        UUID id = modRepository.getIdByChatId(chatId);

        short modAccess = modAccessRepository.getAccessModServiceFor(id);
        if (modAccess == 0){
            //Moderator moderator = new Moderator(moderatorInfo);
            //ModeratorAccess moderatorAccess = new ModeratorAccess(moderator.getId(), moderatorInfo);

            //modRepository.save(moderator);
            //modAccessRepository.save(moderatorAccess);

            //moderatorInfo.setId(moderator.getId());
            modInfoRepository.save(moderatorInfo);

            modActionsRepository.save(
                    new ModeratorAction(
                            id,
                            "create moderator:\n" + moderatorInfo.toString()
                    )
            );
        } else {
            throw new HaveNotAccessException();
        }
    }


    @Transactional
    public void updateModAccess(Long chatId, ModeratorAccess moderatorAccess) throws HaveNotAccessException {
        UUID id = modRepository.getIdByChatId(chatId);

        short modAccess = modAccessRepository.getAccessModServiceFor(id);
        if (modAccess == 0){
            modAccessRepository.save(moderatorAccess);

            modActionsRepository.save(
                    new ModeratorAction(
                            id,
                            "update moderator:\n" + moderatorAccess.toString()
                    )
            );
        } else {
            throw new HaveNotAccessException();
        }
    }


    @Transactional
    public void updateMod(Long chatId, Moderator moderator) throws HaveNotAccessException {
        UUID id = modRepository.getIdByChatId(chatId);

        short modAccess = modAccessRepository.getAccessModServiceFor(id);
        if (modAccess == 0){
            modRepository.save(moderator);

            modActionsRepository.save(
                    new ModeratorAction(
                            id,
                            "update moderator:\n" + moderator.toString()
                    )
            );
        } else {
            throw new HaveNotAccessException();
        }
    }
}
