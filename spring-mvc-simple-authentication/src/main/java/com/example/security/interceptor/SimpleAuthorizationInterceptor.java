package com.example.security.interceptor;

import com.example.security.model.dto.UserDto;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleAuthorizationInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null) {
            writeContent(response, "请登录");
        }

        UserDto userDto = (UserDto) object;

        if (userDto.getAuthorities().contains("p1") && request.getRequestURI().contains("/r/r1")) {
            return true;
        }

        if (userDto.getAuthorities().contains("p2") && request.getRequestURI().contains("/r/r2")) {
            return true;
        }


        writeContent(response, "权限不足，拒接访问");

        return false;
    }

    private void writeContent(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(message);
        writer.close();
    }
}
