package com.zensar.ide;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableEurekaClient
@RestController
@RefreshScope
public class SpringBootCouponServiceApplication {
	/*
	 * public class SpringBootCouponServiceApplication extends
	 * SpringBootServletInitializer{
	 * 
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) {
	 * 
	 * return super.configure(builder); }
	 */
	@Value("${code.myOffer}")
	private String myOffer;
	@Autowired
	private MyConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouponServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@GetMapping("/")
	public String codeConfig() {
		return "Offer is upto " + myOffer + " and applicable to "+myConfig.getApplicableTo();
	}
}
