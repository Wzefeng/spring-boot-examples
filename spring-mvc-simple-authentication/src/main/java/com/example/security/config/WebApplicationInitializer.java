package com.example.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Servlet 容器启动引导类 （相当于web.xml）
 *
 * @author wangzefeng
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        // 指定 rootContext 配置类
        return new Class[]{ApplicationConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        // 指定 servletContext 配置类
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
