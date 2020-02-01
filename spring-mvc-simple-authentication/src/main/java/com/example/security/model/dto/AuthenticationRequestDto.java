package com.example.security.model.dto;

import lombok.Data;

/**
 * 认证 request dto
 */
@Data
public class AuthenticationRequestDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
