package com.darkurfu.modservice.repository.mod;

import com.darkurfu.modservice.datamodels.mod.Moderator;
import com.darkurfu.modservice.datamodels.mod.ModeratorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModRepository extends JpaRepository<Moderator, Long> {

    @Query("select m.id from moderator m where m.chatId = ?1")
    Long getIdByChatId(Long chatId);

    @Query("select m from moderator m where m.chatId = ?1")
    Moderator getReferenceByChatId(Long chatId);
}
