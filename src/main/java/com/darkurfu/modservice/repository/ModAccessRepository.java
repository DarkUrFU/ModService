package com.darkurfu.modservice.repository;

import com.darkurfu.modservice.datamodels.ModeratorAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModAccessRepository extends JpaRepository<ModeratorAccess, Long> {

    @Query("select ")
    short getAccessFor(String chatId, String service);
}
