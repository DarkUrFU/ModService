package com.darkurfu.modservice.repository;

import com.darkurfu.modservice.datamodels.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModRepository extends JpaRepository<Moderator, Long> {

}
