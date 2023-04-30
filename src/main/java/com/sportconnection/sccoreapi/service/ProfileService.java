package com.sportconnection.sccoreapi.service;

import com.sportconnection.sccoreapi.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    void createDefaultProfile(Long userId);
    ProfileDTO create(ProfileDTO dto);
    ProfileDTO update(Long id, ProfileDTO dto);
    ProfileDTO get(Long id);
    List<ProfileDTO> list();
    void delete(Long id);

}
