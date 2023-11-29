package com.darkurfu.modservice.repository.mod;

import com.darkurfu.modservice.datamodels.mod.ModeratorAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModActionsRepository extends JpaRepository<ModeratorAction, UUID> {

}
