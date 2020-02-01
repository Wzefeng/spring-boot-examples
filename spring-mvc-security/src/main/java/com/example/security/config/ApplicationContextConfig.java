package com.example.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Root Application Context(相当于applicationContext.xml)
 *
 * @author wangzefeng
 */
@Configuration
@ComponentScan(basePackages = "com.example.security",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationContextConfig {
}
