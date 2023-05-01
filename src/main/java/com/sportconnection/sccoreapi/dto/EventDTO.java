package com.sportconnection.sccoreapi.dto;

import com.sportconnection.sccoreapi.dto.enums.EventEnum;
import com.sportconnection.sccoreapi.dto.enums.FrequencyEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private FrequencyEnum frequency;
    private String time;
    private String address;
    private EventEnum typeEvent;
    private String icon;
    private Boolean paid;
    private Long profileId;
    private String username;
}
