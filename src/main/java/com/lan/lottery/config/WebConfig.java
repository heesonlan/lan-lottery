package com.lan.lottery.config;


import com.lan.lottery.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/css/");
		registry.addResourceHandler("/js/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/js/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/img/favicon.ico");
		registry.addResourceHandler("/img/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/img/");
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/api/**");
		super.addInterceptors(registry);
	}

}
