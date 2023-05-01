package com.sportconnection.sccoreapi.security.jwt;

import com.sportconnection.sccoreapi.entity.UserEntity;
import com.sportconnection.sccoreapi.repository.UserRepository;
import com.sportconnection.sccoreapi.security.type.RoleAccessType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceJwt implements UserDetailsService /*, UserDetailsManager*/ {

    private UserRepository userRepository;

    public UserDetailsServiceJwt(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findFirstByUsername(username);
        if (userEntity == null) throw new UsernameNotFoundException(String.format("User %s not found!", username));
        return new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
        //return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRoles());   // TODO Implementar ROLES
    }

}
