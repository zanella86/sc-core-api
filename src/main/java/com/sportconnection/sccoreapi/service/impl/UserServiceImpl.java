package com.sportconnection.sccoreapi.service.impl;

import com.sportconnection.sccoreapi.dto.RegisterUserDTO;
import com.sportconnection.sccoreapi.dto.UserDTO;
import com.sportconnection.sccoreapi.entity.UserEntity;
import com.sportconnection.sccoreapi.mapper.UserMapper;
import com.sportconnection.sccoreapi.security.dto.AuthDTO;
import com.sportconnection.sccoreapi.security.dto.JwtDTO;
import com.sportconnection.sccoreapi.repository.UserRepository;
import com.sportconnection.sccoreapi.security.jwt.SecretJwt;
import com.sportconnection.sccoreapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private AuthenticationManager authenticationManager;
    private SecretJwt secretJwt;
    private UserMapper userMapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(AuthenticationManager authenticationManager,
                           SecretJwt secretJwt,
                           UserMapper userMapper,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.secretJwt = secretJwt;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtDTO auth(AuthDTO authDTO) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password()));
        }catch (DisabledException dEx) {
            throw new RuntimeException(String.format("User %s is disabled",authDTO.username()), dEx);
        }catch (LockedException lEx) {
            throw new RuntimeException(String.format("User %s is locked",authDTO.username()), lEx);
        }catch (BadCredentialsException bcEx) {
            throw new RuntimeException(String.format("User %s is not valid",authDTO.username()), bcEx);
        }catch (AuthenticationException aEx) {
            throw new RuntimeException(String.format("Unable to authenticate user %s",authDTO.username()), aEx);
        }
        return new JwtDTO(this.secretJwt.getToken(authDTO.username()));
    }

    @Override
    public UserDTO create(RegisterUserDTO registerUserDTO) {
        UserEntity checkUserEntity = this.userRepository.findFirstByUsername(registerUserDTO.username());
        if(checkUserEntity != null && checkUserEntity.getUsername().equals(registerUserDTO.username())) {
            throw new RuntimeException("User already exists!");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerUserDTO.username());
        userEntity.setPassword(this.passwordEncoder.encode(registerUserDTO.password()));

        UserEntity savedUserEntity = this.userRepository.save(userEntity);
        return this.userMapper.convertToDTO(savedUserEntity);
    }

}
