package com.sportconnection.sccoreapi.entity;

import com.sportconnection.sccoreapi.config.JpaConfig;
import com.sportconnection.sccoreapi.dto.enums.EventEnum;
import com.sportconnection.sccoreapi.dto.enums.FrequencyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_EVENT", catalog = JpaConfig.CATALOG)
public class EventEntity implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private FrequencyEnum frequency;

    @Column
    private String time;

    @Column
    private String address;

    @Column
    private EventEnum typeEvent;

    @Column
    private String icon;

    @Column
    private Boolean paid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;
}
