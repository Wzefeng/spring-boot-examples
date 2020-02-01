package com.example.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Servlet 容器启动引导类 （相当于web.xml）
 *
 * @author wangzefeng
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationContextConfig.class, WebSecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcContextConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
