package com.example.security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TestUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("用户：" + username + "请求登录");

        // 模拟 user 返回
        return User.withUsername(username)
                .password("$2a$10$XwpRbC37kXoXpzdzo0QI0ugPBdjYi35J356kJpHDxOQO3yODMQ8Re")
                .authorities("p1").build();
    }
}
