package com.sportconnection.sccoreapi.repository;

import com.sportconnection.sccoreapi.entity.EventEntity;
import com.sportconnection.sccoreapi.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Query(value = "select ee from EventEntity ee inner join ProfileEntity pe on(pe.id = ee.profile.id) where ee.id = :id and pe.id = :profileId")
    Optional<EventEntity> findByIdAndProfileId(Long id, Long profileId);

    @Query(value = "select ee from EventEntity ee inner join ProfileEntity pe on(pe.id = ee.profile.id) where pe.id = :profileId")
    List<EventEntity> findAllByProfileId(Long profileId);

}
