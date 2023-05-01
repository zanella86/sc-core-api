package com.sportconnection.sccoreapi.repository;

import com.sportconnection.sccoreapi.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    @Query(value = "select tp from ProfileEntity tp inner join UserEntity tu on(tu.id = tp.user.id) where tu.username = :username")
    Optional<ProfileEntity> findByUsername(String username);

}
