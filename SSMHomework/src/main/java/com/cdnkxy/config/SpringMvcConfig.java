package com.cdnkxy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.cdnkxy.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer{
	//开启静态资源访问
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/admin/",".jsp");
	}
	
}
