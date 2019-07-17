package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@ConditionalOnExpression("false")
	public ConditionalBean conditionalBean(ApplicationContext ctx) {
		return new ConditionalBean();
	}

	@Bean
	public ConditionalBean conditionalBean() {
		return new ConditionalBean();
	}

	@Bean
	public SomeOtherBean someOtherBean(ConditionalBean conditionalBean) {
		return new SomeOtherBean();
	}

	public class ConditionalBean {}
	public class SomeOtherBean {}

}
