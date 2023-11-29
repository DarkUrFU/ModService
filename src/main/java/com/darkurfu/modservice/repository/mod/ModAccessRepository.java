package com.darkurfu.modservice.repository.mod;

import com.darkurfu.modservice.datamodels.mod.ModeratorAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModAccessRepository extends JpaRepository<ModeratorAccess, UUID> {

    @Query("select ma.modService from moderator_access ma where ma.id = ?1 ")
    short getAccessModServiceFor(
            UUID id
    );

    @Query("select ma.eventService from moderator_access ma where ma.id = ?1 ")
    short getAccessEventServiceFor(
            UUID id
    );
}
