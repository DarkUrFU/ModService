package com.darkurfu.modservice.repository;

import com.darkurfu.modservice.datamodels.ModeratorAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModAccessRepository extends JpaRepository<ModeratorAccess, Long> {

    @Query("select ma.modService from moderator_access ma where ma.id = ?1 ")
    short getAccessModServiceFor(
            Long id
    );

    @Query("select ma.eventService from moderator_access ma where ma.id = ?1 ")
    short getAccessEventServiceFor(
            Long id
    );
}
