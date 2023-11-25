package com.darkurfu.modservice.service.internal;

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
import java.util.Optional;

@Service
public class ModInfoInternalService {

    private final ModInfoRepository modInfoRepository;


    @Autowired
    public ModInfoInternalService(
            ModInfoRepository modInfoRepository
    ){
        this.modInfoRepository = modInfoRepository;
    }


    //@Transactional
    public ModeratorInfo getModInfo(long modID) throws Exception {


        Optional<ModeratorInfo> moderatorInfo = modInfoRepository.findById(modID);
        if(moderatorInfo.isPresent()){
            return moderatorInfo.get();
        } else{
            throw new Exception("");
        }

    }

    //@Transactional
    public List<ModeratorInfo> getAllModsInfo() {


        return modInfoRepository.findAll();
    }
}
