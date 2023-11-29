package com.darkurfu.modservice.repository.event;

import com.darkurfu.modservice.datamodels.event.EventRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRequestRepository extends JpaRepository<EventRequest, UUID> {

}
