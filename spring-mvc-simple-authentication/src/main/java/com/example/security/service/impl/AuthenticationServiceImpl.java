package com.example.security.service.impl;

import com.example.security.model.dto.AuthenticationRequestDto;
import com.example.security.model.dto.UserDto;
import com.example.security.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private Map<String, UserDto> userRepository = new HashMap<String, UserDto>();

    {
        Set<String> authorities1 = new HashSet<String>();
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<String>();
        authorities2.add("p2");

        userRepository.put("zhangsan",
                new UserDto("1001", "zhangsan", "123456", "张三", "1351234", authorities1));
        userRepository.put("lisi",
                new UserDto("1002", "lisi", "123", "李四", "1381234", authorities2));
    }

    public UserDto authentication(AuthenticationRequestDto authenticationRequestDto) {

        validate(authenticationRequestDto);

        UserDto userDto = getUserDto(authenticationRequestDto.getUsername());

        if (userDto == null) {
            throw new RuntimeException("该用户信息不存在");
        }

        if (!authenticationRequestDto.getPassword().equals(userDto.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        return userDto;
    }

    private UserDto getUserDto(String username) {
        return userRepository.get(username);
    }

    private void validate(AuthenticationRequestDto authenticationRequestDto) {
        if (authenticationRequestDto == null || StringUtils.isEmpty(authenticationRequestDto.getUsername())
                || StringUtils.isEmpty(authenticationRequestDto.getPassword())) {
            throw new RuntimeException("用户名和密码不能为空");
        }
    }
}
