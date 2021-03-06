package com.zensar.ide;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
//public class SpringBootProductServiceApplication extends SpringBootServletInitializer {
@OpenAPIDefinition
@EnableEurekaClient
@EnableFeignClients
@EnableOAuth2Sso
public class SpringBootProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) {
	 * 
	 * return super.configure(builder); }
	 */

}
