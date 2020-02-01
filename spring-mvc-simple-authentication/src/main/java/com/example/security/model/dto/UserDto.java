package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * 用户信息 dto
 */
@Data
@AllArgsConstructor
public class UserDto {

    public static final String SESSION_USER_KEY = "_user";

    /**
     * ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 完整姓名
     */
    private String fullName;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 权限集合
     */
    private Set<String> authorities;
}
