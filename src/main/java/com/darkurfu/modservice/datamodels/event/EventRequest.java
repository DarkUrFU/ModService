package com.darkurfu.modservice.datamodels.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EventRequest {
    @Id
    private Long id;


}
