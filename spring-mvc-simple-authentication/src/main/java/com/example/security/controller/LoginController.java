package com.example.security.controller;

import com.example.security.model.dto.AuthenticationRequestDto;
import com.example.security.model.dto.UserDto;
import com.example.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 登录认证 Controller
 */
@RestController
public class LoginController {


    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRequestDto authenticationRequestDto, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequestDto);

        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);

        return "认证成功：" + userDto.toString();
    }

    @GetMapping(value = "/logout", produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession session) {
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/r/r1", produces = "text/plain;charset=UTF-8")
    public String r1(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userDto == null) {
            return "匿名访问资源r1";
        } else {
            return userDto.getFullName() + "访问资源r1";
        }
    }

    @GetMapping(value = "/r/r2", produces = "text/plain;charset=UTF-8")
    public String r2(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userDto == null) {
            return "匿名访问资源r2";
        } else {
            return userDto.getFullName() + "访问资源r2";
        }
    }
}
