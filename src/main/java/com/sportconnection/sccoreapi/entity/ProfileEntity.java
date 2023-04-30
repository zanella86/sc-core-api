package com.sportconnection.sccoreapi.entity;

import com.sportconnection.sccoreapi.config.JpaConfig;
import com.sportconnection.sccoreapi.dto.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "TB_PROFILE", catalog = JpaConfig.CATALOG)
public class ProfileEntity implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private LevelEnum level;

    @Column
    private int score;

    @Column
    private int eventsParticipated;

    @Column
    private int achievements;

    @Column
    private int friends;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="profile")
    private Set<EventEntity> events = new HashSet<>();

    @OneToOne
    private UserEntity user;

}
