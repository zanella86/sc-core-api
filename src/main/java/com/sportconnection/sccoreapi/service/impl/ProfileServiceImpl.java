package com.sportconnection.sccoreapi.service.impl;

import com.sportconnection.sccoreapi.dto.ProfileDTO;
import com.sportconnection.sccoreapi.dto.enums.LevelEnum;
import com.sportconnection.sccoreapi.entity.ProfileEntity;
import com.sportconnection.sccoreapi.entity.UserEntity;
import com.sportconnection.sccoreapi.mapper.ProfileMapper;
import com.sportconnection.sccoreapi.repository.ProfileRepository;
import com.sportconnection.sccoreapi.repository.UserRepository;
import com.sportconnection.sccoreapi.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    ProfileRepository repository;
    UserRepository userRepository;
    ProfileMapper mapper;

    @Override
    public void createDefaultProfile(Long userId) {
        var user = userRepository.findById(userId);
        user.orElseThrow(() -> new NoSuchElementException());
        var entity = repository.save(getProfileEntityWithDefaultValues(user.get()));
    }

    @Override
    public ProfileDTO create(ProfileDTO dto) {
        var user = userRepository.findById(dto.getUserId());
        user.orElseThrow(() -> new NoSuchElementException());

        var entity = mapper.convertToEntity(dto);
        entity.setUser(user.get());
        entity = repository.save(entity);
        return mapper.convertToDTO(entity);
    }

    @Override
    public ProfileDTO update(Long id, ProfileDTO dto) {
        var user = userRepository.findById(dto.getUserId());
        user.orElseThrow(() -> new NoSuchElementException());

        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());

        var updateEntity = mapper.convertToEntity(dto);
        updateEntity.setId(id);
        updateEntity.setUser(user.get());

        updateEntity = repository.save(updateEntity);

        return mapper.convertToDTO(updateEntity);
    }

    @Override
    public ProfileDTO get(Long id) {
        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());
        return mapper.convertToDTO(entity.get());
    }

    @Override
    public List<ProfileDTO> list() {
        var entities = repository.findAll();
        if (Objects.isNull(entities) || entities.isEmpty()) return new ArrayList<>();
        return entities.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        var entity = repository.findById(id);
        entity.orElseThrow(() -> new NoSuchElementException());
        repository.delete(entity.get());
    }

    private ProfileEntity getProfileEntityWithDefaultValues(UserEntity user) {
        return ProfileEntity.builder()
                .name(user.getUsername())
                .phone("")
                .score(0)
                .level(LevelEnum.BROWN)
                .eventsParticipated(0)
                .achievements(0)
                .friends(0)
                .user(user)
                .build();
    }
}
