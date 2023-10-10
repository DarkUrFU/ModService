package com.darkurfu.modservice.repository;

import com.darkurfu.modservice.datamodels.EventRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {

}
