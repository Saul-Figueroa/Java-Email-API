package com.cts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cts.aop.BookServiceAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {
	@Bean
	public BookServiceAspect loggingAspect() {
		return new BookServiceAspect();
	}
	

}
