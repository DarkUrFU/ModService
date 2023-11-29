package com.darkurfu.modservice.repository.mod;

import com.darkurfu.modservice.datamodels.mod.Moderator;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModRepository extends JpaRepository<Moderator, UUID> {

    @Query("select m.id from moderator m where m.chatId = ?1")
    UUID getIdByChatId(long chatId);

    @Query("select m from moderator m where m.chatId = ?1")
    Moderator getReferenceByChatId(long chatId);
}
