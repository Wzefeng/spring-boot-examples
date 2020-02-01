package com.example.security.service;

import com.example.security.model.dto.AuthenticationRequestDto;
import com.example.security.model.dto.UserDto;

/**
 * 用户认证 Service
 */
public interface AuthenticationService {

    /**
     * 认证
     *
     * @param authenticationRequestDto
     * @return
     */
    UserDto authentication(AuthenticationRequestDto authenticationRequestDto);
}
