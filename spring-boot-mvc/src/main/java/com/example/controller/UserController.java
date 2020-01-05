package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangzefeng
 * @date 2020/1/5 14:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public User save(@RequestBody User user, HttpServletRequest request) {
        user.setId(1000L);
        return user;
    }

}
