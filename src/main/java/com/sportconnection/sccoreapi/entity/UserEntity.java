package com.sportconnection.sccoreapi.entity;

import com.sportconnection.sccoreapi.config.JpaConfig;
import com.sportconnection.sccoreapi.security.type.RoleAccessType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_USER", catalog = JpaConfig.CATALOG)
public class UserEntity implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    /*@Column
    private List<RoleAccessType> roles;*/

}
