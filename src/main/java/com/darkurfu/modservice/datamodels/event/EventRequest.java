package com.darkurfu.modservice.datamodels.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class EventRequest {
    @Id
    private UUID id;


}
