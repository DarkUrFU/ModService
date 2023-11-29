package com.darkurfu.modservice.repository.mod;

import com.darkurfu.modservice.datamodels.mod.Moderator;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModInfoRepository extends JpaRepository<ModeratorInfo, UUID> {

    ModeratorInfo getReferenceByChatId(Long chatId);
}
